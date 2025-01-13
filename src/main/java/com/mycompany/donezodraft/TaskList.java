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
        // Simulated tasks (replace with file/database operations if needed)
        tasks.add(new Task("Sample Task", "A sample description", LocalDate.now(), 3, "Not Yet Started", "Medium"));
        updateTaskList();
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

        String name = (String) tableModel.getValueAt(selectedRow, 0);
        String description = (String) tableModel.getValueAt(selectedRow, 1);
        LocalDate dueDate = LocalDate.parse((String) tableModel.getValueAt(selectedRow, 2));
        int time = Integer.parseInt(tableModel.getValueAt(selectedRow, 3).toString());
        String status = (String) tableModel.getValueAt(selectedRow, 4);
        String difficulty = (String) tableModel.getValueAt(selectedRow, 5);

        tasks.set(selectedRow, new Task(name, description, dueDate, time, status, difficulty));
        updateTaskList();
    }

    private void deleteTask() {
        int selectedRow = taskTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a task to delete!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        tasks.remove(selectedRow);
        tableModel.removeRow(selectedRow);
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
