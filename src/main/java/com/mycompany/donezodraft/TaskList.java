package com.mycompany.donezodraft;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.*;

public class TaskList extends JInternalFrame {
    private JTable taskTable;
    private DefaultTableModel tableModel;
    private JPanel inputPanel;
    private String[] columnNames = { "Task Name", "Description", "Due Date", "Time", "Status", "Difficulty" };
    private static final ArrayList<Task> tasks = new ArrayList<>();
    private static final String[] statuses = { "Not Yet Started", "In Progress", "Completed" };
    private static final String[] difficulties = { "Easy", "Medium", "Hard" };
    private static final String FILE_PATH = "database.txt";
    
    public TaskList() {
        super("My Tasks", false, false, false, false); 
        setSize(979, 693);
        setLayout(new BorderLayout());
        setBorder(null); // Remove the default border

        // Remove the title bar (header)
        BasicInternalFrameUI internalFrameUI = (BasicInternalFrameUI) this.getUI();
        internalFrameUI.setNorthPane(null); // This removes the title bar


        JLabel titleLabel = new JLabel("My Tasks", SwingConstants.LEFT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 2, 66));
        titleLabel.setBorder(new EmptyBorder(10, 20, 10, 10));
        add(titleLabel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4 || column == 5; 
            }
        };
        
        taskTable = new JTable(tableModel);
        taskTable.setRowHeight(50);
        taskTable.setFont(new Font("Arial", Font.PLAIN, 14));
        taskTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        taskTable.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(new JComboBox<>(statuses)));
        taskTable.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(new JComboBox<>(difficulties)));

        JScrollPane scrollPane = new JScrollPane(taskTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        add(scrollPane, BorderLayout.CENTER);

        inputPanel = createInputPanel();
        inputPanel.setVisible(false);

        JPanel buttonPanel = createButtonPanel();

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputPanel, BorderLayout.NORTH);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        // Load tasks
        loadTasks();
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(1, columnNames.length, 10, 0));
        panel.setBorder(new EmptyBorder(10, 20, 10, 20));

        JTextField taskNameField = new JTextField();
        JTextField taskDescriptionField = new JTextField();
        JTextField dueDateField = new JTextField();
        JTextField timeField = new JTextField();
        JComboBox<String> statusField = new JComboBox<>(statuses);
        JComboBox<String> difficultyField = new JComboBox<>(difficulties);

        panel.add(taskNameField);
        panel.add(taskDescriptionField);
        panel.add(dueDateField);
        panel.add(timeField);
        panel.add(statusField);
        panel.add(difficultyField);

        JButton submitButton = new JButton("Add Task");
        submitButton.addActionListener(e -> {
            try {
                Task newTask = new Task(
                    taskNameField.getText(),
                    taskDescriptionField.getText(),
                    LocalDate.parse(dueDateField.getText()),
                    Integer.parseInt(timeField.getText()),
                    (String) statusField.getSelectedItem(),
                    (String) difficultyField.getSelectedItem()
                );

                tasks.add(newTask);
                tableModel.addRow(new Object[] {
                    newTask.getName(),
                    newTask.getDescription(),
                    newTask.getDueDate().toString(),
                    newTask.getTimeAllotted(),
                    newTask.getProgress(),
                    newTask.getDifficulty()
                });
                FileH.funcAddTaskToFile(FILE_PATH, newTask); //ADDED FILEH FUNCTION
                clearFields(taskNameField, taskDescriptionField, dueDateField, timeField, statusField, difficultyField);
                inputPanel.setVisible(false);
                revalidate();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(submitButton);
        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton addTaskButton = new JButton("+ Add Task");
        addTaskButton.addActionListener(e -> inputPanel.setVisible(true));
        panel.add(addTaskButton);

        JButton editTaskButton = new JButton("Edit Task");
        editTaskButton.addActionListener(e -> editTask());
        panel.add(editTaskButton);

        JButton deleteTaskButton = new JButton("Delete Task");
        deleteTaskButton.addActionListener(e -> deleteTask());
        panel.add(deleteTaskButton);

        return panel;
    }

    private void loadTasks() {
        ArrayList<Task> loadedTasks = FileH.funcReadFile(FILE_PATH);
        if (loadedTasks != null) {
            tasks.clear();
            tasks.addAll(loadedTasks);
            updateTaskList();
        } else {
            System.out.println("No saved tasks found.");
        }
    }

    private void updateTaskList() {
        tableModel.setRowCount(0); // Clear existing rows
        for (Task task : tasks) {
            tableModel.addRow(new Object[] {
                task.getName(),
                task.getDescription(),
                task.getDueDate().toString(),
                task.getTimeAllotted(),
                task.getProgress(),
                task.getDifficulty()
            });
        }
    }

    private void editTask() {
        int selectedRow = taskTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a task to edit!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        // Retrieve existing values
        String currentTaskName = (String) tableModel.getValueAt(selectedRow, 0);
        String currentDescription = (String) tableModel.getValueAt(selectedRow, 1);
        String currentDueDate = (String) tableModel.getValueAt(selectedRow, 2);
        String currentTime = String.valueOf(tableModel.getValueAt(selectedRow, 3));
        String currentStatus = (String) tableModel.getValueAt(selectedRow, 4);
        String currentDifficulty = (String) tableModel.getValueAt(selectedRow, 5);
    
        // Create edit fields
        JTextField taskNameField = new JTextField(currentTaskName);
        JTextField taskDescriptionField = new JTextField(currentDescription);
        JTextField dueDateField = new JTextField(currentDueDate);
        JTextField timeField = new JTextField(currentTime);
        JComboBox<String> statusField = new JComboBox<>(statuses);
        statusField.setSelectedItem(currentStatus);
        JComboBox<String> difficultyField = new JComboBox<>(difficulties);
        difficultyField.setSelectedItem(currentDifficulty);
    
        // Create a panel for input
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.add(new JLabel("Task Name:"));
        panel.add(taskNameField);
        panel.add(new JLabel("Description:"));
        panel.add(taskDescriptionField);
        panel.add(new JLabel("Due Date (YYYY-MM-DD):"));
        panel.add(dueDateField);
        panel.add(new JLabel("Time (e.g., 3 hours):"));
        panel.add(timeField);
        panel.add(new JLabel("Status:"));
        panel.add(statusField);
        panel.add(new JLabel("Difficulty:"));
        panel.add(difficultyField);
    
        // Show dialog
        int result = JOptionPane.showConfirmDialog(this, panel, "Edit Task", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            try {
                // Update table
                tableModel.setValueAt(taskNameField.getText(), selectedRow, 0);
                tableModel.setValueAt(taskDescriptionField.getText(), selectedRow, 1);
                tableModel.setValueAt(dueDateField.getText(), selectedRow, 2);
                tableModel.setValueAt(timeField.getText(), selectedRow, 3);
                tableModel.setValueAt(statusField.getSelectedItem(), selectedRow, 4);
                tableModel.setValueAt(difficultyField.getSelectedItem(), selectedRow, 5);
    
                // Update task list
                Task updatedTask = tasks.get(selectedRow);
                updatedTask.setName(taskNameField.getText());
                updatedTask.setDescription(taskDescriptionField.getText());
                updatedTask.setDueDate(LocalDate.parse(dueDateField.getText()));
                updatedTask.setTimeAllotted(Integer.parseInt(timeField.getText()));
                updatedTask.setProgress((String) statusField.getSelectedItem());
                updatedTask.setDifficulty((String) difficultyField.getSelectedItem());
    
                // Save to file
                FileH.funcWriteAllTasksToFile(FILE_PATH, tasks);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error updating task: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void deleteTask() {
        int selectedRow = taskTable.getSelectedRow();
            if (selectedRow != -1) {
                tasks.remove(selectedRow);
                tableModel.removeRow(selectedRow);
                FileH.funcWriteAllTasksToFile(FILE_PATH, tasks);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a task to delete!", "Error", JOptionPane.ERROR_MESSAGE);
            }
    }

    private void clearFields(JTextField taskName, JTextField taskDescription, JTextField dueDate,
                             JTextField timeField, JComboBox<String> statusField, JComboBox<String> difficultyField) {
        taskName.setText("");
        taskDescription.setText("");
        dueDate.setText("");
        timeField.setText("");
        statusField.setSelectedIndex(0);
        difficultyField.setSelectedIndex(0);
    }
}
