/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.donezodraft;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author jaspe
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    
    Color DefaultColor, ClickedColor;
    public Main() {
        initComponents();
        DefaultColor = new Color(200,209,218);
        ClickedColor = new Color(0,0,102);
        
        pnlDashboard.setBackground(ClickedColor);
        pnlTaskList.setBackground(DefaultColor);
        pnlWorkflow.setBackground(DefaultColor);
        pnlSettings.setBackground(DefaultColor);
        
        setBounds(350,120,1285,708);
        initializeListeners();
                
        try {
        InputStream outfitFontStream = getClass().getResourceAsStream("/fontStyles/Outfit-ExtraBold.ttf");
        Font outfitFont = Font.createFont(Font.TRUETYPE_FONT, outfitFontStream).deriveFont(20f);
        lblDashboard.setFont(outfitFont);
        lblSettings.setFont(outfitFont);
        lblWorkflow.setFont(outfitFont);
        lblTaskList.setFont(outfitFont);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
        InputStream outfitFontStream = getClass().getResourceAsStream("/fontStyles/Outfit-ExtraBold.ttf");
        Font outfitFont = Font.createFont(Font.TRUETYPE_FONT, outfitFontStream).deriveFont(25f);
        lblLogo.setFont(outfitFont);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        loadFont("/fontStyles/Outfit-ExtraBold.ttf", 28f, lblHeading);
        loadFont("/fontStyles/Outfit-ExtraBold.ttf", 40f, lblGreeting);
        loadFont("/fontStyles/Montserrat-Medium.ttf", 16f, lblMessage);
        loadFont("/fontStyles/Outfit-Bold.ttf", 20f, lblTasks, lblTime, lblProgress, lblPriorities);
        loadFont("/fontStyles/Outfit-Regular.ttf", 16f, lblTasksRemaining, lblTimeRemaining, lblProgressDone);
        loadFont("/fontStyles/Outfit-Regular.ttf", 14f, lblCountImmediate, lblCountStart, lblCountLater);
        loadFont("/fontStyles/Outfit-SemiBold.ttf", 16f, lblImmediate, lblStartEarly, lblScheduleLater);
        initializeListeners();
    }
    
    private void loadFont(String path, float size, JLabel... labels) {
        try {
            InputStream fontStream = getClass().getResourceAsStream(path);
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(size);
            for (JLabel label : labels) {
                label.setFont(font);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void scaleImage() {
        // Scale and set images for all labels
        setScaledImage(iconTasks, "/IconImages/tasks.png");
        setScaledImage(iconTime, "/IconImages/time.png");
        setScaledImage(iconProgress, "/IconImages/progress.png");
        setScaledImage(iconLogo, "/IconImages/with bg.png");
        setScaledImage(iconDashboard, "/Icon/dashboard white.png");
        setScaledImage(iconTasklist, "/Icon/tasks white.png");
        setScaledImage(iconWorkflow, "/Icon/workflow white.png");
        setScaledImage(iconSettings, "/Icon/settings white.png");
    }

    private void setScaledImage(JLabel label, String resourcePath) {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource(resourcePath));
            Image img = icon.getImage();
            Image scaledImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(scaledImg));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addResizeListenerToLabels(JLabel... labels) {
        ComponentAdapter resizeListener = new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                scaleImage();
            }
        };

        for (JLabel label : labels) {
            label.addComponentListener(resizeListener);
        }
    }

    private void initializeListeners() {
        // Add the resize listener to all relevant labels
        addResizeListenerToLabels(iconTasks, iconTime, iconProgress, iconLogo, iconDashboard, iconTasklist, iconWorkflow, iconSettings);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMenu = new javax.swing.JPanel();
        pnlDashboard = new javax.swing.JPanel();
        lblDashboard = new javax.swing.JLabel();
        iconDashboard = new javax.swing.JLabel();
        pnlTaskList = new javax.swing.JPanel();
        lblTaskList = new javax.swing.JLabel();
        iconTasklist = new javax.swing.JLabel();
        pnlWorkflow = new javax.swing.JPanel();
        lblWorkflow = new javax.swing.JLabel();
        iconWorkflow = new javax.swing.JLabel();
        pnlSettings = new javax.swing.JPanel();
        lblSettings = new javax.swing.JLabel();
        iconSettings = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        iconLogo = new javax.swing.JLabel();
        pnlMain = new javax.swing.JDesktopPane();
        lblSummary = new javax.swing.JLabel();
        pnlCalendar = new javax.swing.JPanel();
        pnlTime = new javax.swing.JPanel();
        iconTime = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblTimeRemaining = new javax.swing.JLabel();
        pnlTaskRemaining = new javax.swing.JPanel();
        iconTasks = new javax.swing.JLabel();
        lblTasks = new javax.swing.JLabel();
        lblTasksRemaining = new javax.swing.JLabel();
        lblHeading = new javax.swing.JLabel();
        pnlGreeting = new javax.swing.JPanel();
        lblGreeting = new javax.swing.JLabel();
        lblMessage = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblMascot = new javax.swing.JLabel();
        pnlPriorities = new javax.swing.JPanel();
        lblPriorities = new javax.swing.JLabel();
        lblImmediate = new javax.swing.JLabel();
        lblCountImmediate = new javax.swing.JLabel();
        lblStartEarly = new javax.swing.JLabel();
        lblCountStart = new javax.swing.JLabel();
        lblScheduleLater = new javax.swing.JLabel();
        lblCountLater = new javax.swing.JLabel();
        pnlProgress = new javax.swing.JPanel();
        iconProgress = new javax.swing.JLabel();
        lblProgressDone = new javax.swing.JLabel();
        lblProgress = new javax.swing.JLabel();
        progressBar1 = new com.mycompany.donezodraft.ProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenu.setBackground(new java.awt.Color(199, 210, 221));
        pnlMenu.setForeground(new java.awt.Color(199, 210, 221));
        pnlMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlDashboard.setBackground(new java.awt.Color(199, 210, 221));
        pnlDashboard.setForeground(new java.awt.Color(199, 210, 221));
        pnlDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlDashboardMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlDashboardMousePressed(evt);
            }
        });

        lblDashboard.setBackground(new java.awt.Color(194, 204, 214));
        lblDashboard.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblDashboard.setForeground(new java.awt.Color(255, 255, 255));
        lblDashboard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDashboard.setText("Dashboard");

        javax.swing.GroupLayout pnlDashboardLayout = new javax.swing.GroupLayout(pnlDashboard);
        pnlDashboard.setLayout(pnlDashboardLayout);
        pnlDashboardLayout.setHorizontalGroup(
            pnlDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDashboardLayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(iconDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        pnlDashboardLayout.setVerticalGroup(
            pnlDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDashboardLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlDashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMenu.add(pnlDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 270, 60));

        pnlTaskList.setBackground(new java.awt.Color(199, 210, 221));
        pnlTaskList.setForeground(new java.awt.Color(199, 210, 221));
        pnlTaskList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlTaskListMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlTaskListMousePressed(evt);
            }
        });

        lblTaskList.setBackground(new java.awt.Color(200, 209, 218));
        lblTaskList.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTaskList.setForeground(new java.awt.Color(255, 255, 255));
        lblTaskList.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTaskList.setText("My Tasks");

        javax.swing.GroupLayout pnlTaskListLayout = new javax.swing.GroupLayout(pnlTaskList);
        pnlTaskList.setLayout(pnlTaskListLayout);
        pnlTaskListLayout.setHorizontalGroup(
            pnlTaskListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTaskListLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(iconTasklist, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTaskList, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        pnlTaskListLayout.setVerticalGroup(
            pnlTaskListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTaskList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnlTaskListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconTasklist, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlMenu.add(pnlTaskList, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 270, -1));

        pnlWorkflow.setBackground(new java.awt.Color(199, 210, 221));
        pnlWorkflow.setForeground(new java.awt.Color(199, 210, 221));
        pnlWorkflow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlWorkflowMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlWorkflowMousePressed(evt);
            }
        });

        lblWorkflow.setBackground(new java.awt.Color(200, 209, 218));
        lblWorkflow.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblWorkflow.setForeground(new java.awt.Color(255, 255, 255));
        lblWorkflow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblWorkflow.setText("Workflow");

        iconWorkflow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlWorkflowLayout = new javax.swing.GroupLayout(pnlWorkflow);
        pnlWorkflow.setLayout(pnlWorkflowLayout);
        pnlWorkflowLayout.setHorizontalGroup(
            pnlWorkflowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlWorkflowLayout.createSequentialGroup()
                .addGap(0, 46, Short.MAX_VALUE)
                .addComponent(iconWorkflow, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblWorkflow, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlWorkflowLayout.setVerticalGroup(
            pnlWorkflowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWorkflow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnlWorkflowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconWorkflow, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlMenu.add(pnlWorkflow, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 270, -1));

        pnlSettings.setBackground(new java.awt.Color(199, 210, 221));
        pnlSettings.setForeground(new java.awt.Color(199, 210, 221));
        pnlSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSettingsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlSettingsMousePressed(evt);
            }
        });

        lblSettings.setBackground(new java.awt.Color(200, 209, 218));
        lblSettings.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblSettings.setForeground(new java.awt.Color(255, 255, 255));
        lblSettings.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSettings.setText("Settings");

        javax.swing.GroupLayout pnlSettingsLayout = new javax.swing.GroupLayout(pnlSettings);
        pnlSettings.setLayout(pnlSettingsLayout);
        pnlSettingsLayout.setHorizontalGroup(
            pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSettingsLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(iconSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pnlSettingsLayout.setVerticalGroup(
            pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSettingsLayout.createSequentialGroup()
                .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSettingsLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSettingsLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(iconSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pnlMenu.add(pnlSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, -1, -1));

        lblLogo.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(1, 33, 66));
        lblLogo.setText("DoneZo!");
        pnlMenu.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 140, 50));
        pnlMenu.add(iconLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 60, 50));

        getContentPane().add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 274, 693));

        pnlMain.setBackground(new java.awt.Color(231, 231, 231));
        pnlMain.setPreferredSize(new java.awt.Dimension(979, 693));

        lblSummary.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSummary.setForeground(new java.awt.Color(102, 102, 102));
        lblSummary.setText("Task Summary");
        pnlMain.add(lblSummary);
        lblSummary.setBounds(40, 220, 124, 25);

        pnlCalendar.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlCalendarLayout = new javax.swing.GroupLayout(pnlCalendar);
        pnlCalendar.setLayout(pnlCalendarLayout);
        pnlCalendarLayout.setHorizontalGroup(
            pnlCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        pnlCalendarLayout.setVerticalGroup(
            pnlCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pnlMain.add(pnlCalendar);
        pnlCalendar.setBounds(670, 270, 260, 300);

        pnlTime.setBackground(new java.awt.Color(255, 255, 255));

        lblTime.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTime.setForeground(new java.awt.Color(1, 33, 66));
        lblTime.setText("Time");

        lblTimeRemaining.setForeground(new java.awt.Color(1, 33, 66));
        lblTimeRemaining.setText("No. Hours Remaining");

        javax.swing.GroupLayout pnlTimeLayout = new javax.swing.GroupLayout(pnlTime);
        pnlTime.setLayout(pnlTimeLayout);
        pnlTimeLayout.setHorizontalGroup(
            pnlTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimeLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(iconTime, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTime)
                    .addComponent(lblTimeRemaining))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        pnlTimeLayout.setVerticalGroup(
            pnlTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTimeLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(pnlTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTimeLayout.createSequentialGroup()
                        .addComponent(lblTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTimeRemaining))
                    .addComponent(iconTime, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        pnlMain.add(pnlTime);
        pnlTime.setBounds(60, 380, 344, 107);

        pnlTaskRemaining.setBackground(new java.awt.Color(255, 255, 255));

        lblTasks.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTasks.setForeground(new java.awt.Color(1, 33, 66));
        lblTasks.setText("Tasks");

        lblTasksRemaining.setForeground(new java.awt.Color(1, 33, 66));
        lblTasksRemaining.setText("No. Task Remaining");

        javax.swing.GroupLayout pnlTaskRemainingLayout = new javax.swing.GroupLayout(pnlTaskRemaining);
        pnlTaskRemaining.setLayout(pnlTaskRemainingLayout);
        pnlTaskRemainingLayout.setHorizontalGroup(
            pnlTaskRemainingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTaskRemainingLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(iconTasks, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlTaskRemainingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTasks)
                    .addComponent(lblTasksRemaining))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTaskRemainingLayout.setVerticalGroup(
            pnlTaskRemainingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTaskRemainingLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlTaskRemainingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconTasks, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlTaskRemainingLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lblTasks)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTasksRemaining)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnlMain.add(pnlTaskRemaining);
        pnlTaskRemaining.setBounds(60, 260, 340, 108);

        lblHeading.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblHeading.setText("Dashboard");
        pnlMain.add(lblHeading);
        lblHeading.setBounds(30, 10, 183, 48);

        pnlGreeting.setBackground(new java.awt.Color(0, 0, 102));
        pnlGreeting.setForeground(new java.awt.Color(0, 0, 102));

        lblGreeting.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblGreeting.setForeground(new java.awt.Color(255, 255, 255));
        lblGreeting.setText("Hello, Name!");

        lblMessage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(255, 255, 255));
        lblMessage.setText("Are you ready to start your day with me?");

        jPanel2.setBackground(new java.awt.Color(231, 231, 231));

        lblMascot.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblMascot.setText("MASCOT NIYO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(160, Short.MAX_VALUE)
                .addComponent(lblMascot)
                .addGap(143, 143, 143))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMascot)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlGreetingLayout = new javax.swing.GroupLayout(pnlGreeting);
        pnlGreeting.setLayout(pnlGreetingLayout);
        pnlGreetingLayout.setHorizontalGroup(
            pnlGreetingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGreetingLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlGreetingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGreetingLayout.createSequentialGroup()
                        .addComponent(lblMessage)
                        .addGap(0, 136, Short.MAX_VALUE))
                    .addComponent(lblGreeting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlGreetingLayout.setVerticalGroup(
            pnlGreetingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGreetingLayout.createSequentialGroup()
                .addGroup(pnlGreetingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGreetingLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lblGreeting, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlGreetingLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pnlMain.add(pnlGreeting);
        pnlGreeting.setBounds(30, 80, 895, 137);

        pnlPriorities.setBackground(new java.awt.Color(255, 255, 255));

        lblPriorities.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPriorities.setForeground(new java.awt.Color(1, 33, 66));
        lblPriorities.setText("Tasks Priorities");

        lblImmediate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblImmediate.setForeground(new java.awt.Color(119, 19, 19));
        lblImmediate.setText("Do Immediately:");

        lblCountImmediate.setForeground(new java.awt.Color(1, 33, 66));
        lblCountImmediate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCountImmediate.setText("No. task/s remaining");

        lblStartEarly.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblStartEarly.setForeground(new java.awt.Color(21, 41, 124));
        lblStartEarly.setText("Start Early:");

        lblCountStart.setForeground(new java.awt.Color(1, 33, 66));
        lblCountStart.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCountStart.setText("No. task/s remaining");

        lblScheduleLater.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblScheduleLater.setForeground(new java.awt.Color(43, 117, 24));
        lblScheduleLater.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblScheduleLater.setText("Schedule Later:");

        lblCountLater.setForeground(new java.awt.Color(1, 33, 66));
        lblCountLater.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCountLater.setText("No. task/s remaining");

        javax.swing.GroupLayout pnlPrioritiesLayout = new javax.swing.GroupLayout(pnlPriorities);
        pnlPriorities.setLayout(pnlPrioritiesLayout);
        pnlPrioritiesLayout.setHorizontalGroup(
            pnlPrioritiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrioritiesLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlPrioritiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPriorities)
                    .addGroup(pnlPrioritiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlPrioritiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPrioritiesLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblCountStart))
                            .addComponent(lblStartEarly))
                        .addGroup(pnlPrioritiesLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(pnlPrioritiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlPrioritiesLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(lblCountImmediate))
                                .addComponent(lblImmediate)))
                        .addGroup(pnlPrioritiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPrioritiesLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblCountLater))
                            .addComponent(lblScheduleLater))))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        pnlPrioritiesLayout.setVerticalGroup(
            pnlPrioritiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrioritiesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblPriorities)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblImmediate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCountImmediate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStartEarly)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCountStart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblScheduleLater)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCountLater)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMain.add(pnlPriorities);
        pnlPriorities.setBounds(420, 260, 230, 230);

        pnlProgress.setBackground(new java.awt.Color(255, 255, 255));

        lblProgressDone.setForeground(new java.awt.Color(1, 33, 66));
        lblProgressDone.setText("No./No. tasks completed! ");

        lblProgress.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblProgress.setForeground(new java.awt.Color(1, 33, 66));
        lblProgress.setText("Your Progress");

        progressBar1.setForeground(new java.awt.Color(0, 0, 102));
        progressBar1.setValue(40);

        javax.swing.GroupLayout pnlProgressLayout = new javax.swing.GroupLayout(pnlProgress);
        pnlProgress.setLayout(pnlProgressLayout);
        pnlProgressLayout.setHorizontalGroup(
            pnlProgressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProgressLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(iconProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlProgressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProgress)
                    .addComponent(lblProgressDone)
                    .addComponent(progressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        pnlProgressLayout.setVerticalGroup(
            pnlProgressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProgressLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlProgressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProgressLayout.createSequentialGroup()
                        .addComponent(lblProgress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblProgressDone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(progressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(iconProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        pnlMain.add(pnlProgress);
        pnlProgress.setBounds(60, 510, 584, 131);

        getContentPane().add(pnlMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void pnlDashboardMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDashboardMousePressed
        // TODO add your handling code here:
        pnlDashboard.setBackground(ClickedColor);
        pnlTaskList.setBackground(DefaultColor);
        pnlWorkflow.setBackground(DefaultColor);
        pnlSettings.setBackground(DefaultColor);
    }//GEN-LAST:event_pnlDashboardMousePressed

    private void pnlTaskListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTaskListMousePressed
        // TODO add your handling code here:
        pnlDashboard.setBackground(DefaultColor);
        pnlTaskList.setBackground(ClickedColor);
        pnlWorkflow.setBackground(DefaultColor);
        pnlSettings.setBackground(DefaultColor);
    }//GEN-LAST:event_pnlTaskListMousePressed

    private void pnlWorkflowMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlWorkflowMousePressed
        // TODO add your handling code here:
        pnlDashboard.setBackground(DefaultColor);
        pnlTaskList.setBackground(DefaultColor);
        pnlWorkflow.setBackground(ClickedColor);
        pnlSettings.setBackground(DefaultColor);
    }//GEN-LAST:event_pnlWorkflowMousePressed

    private void pnlSettingsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSettingsMousePressed
        // TODO add your handling code here:
        pnlDashboard.setBackground(DefaultColor);
        pnlTaskList.setBackground(DefaultColor);
        pnlWorkflow.setBackground(DefaultColor);
        pnlSettings.setBackground(ClickedColor);
    }//GEN-LAST:event_pnlSettingsMousePressed

    private void pnlDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDashboardMouseClicked
        // TODO add your handling code here:
        Dashboard dashboard = new Dashboard();
        pnlMain.removeAll();
        pnlMain.add(dashboard).setVisible(true);
    }//GEN-LAST:event_pnlDashboardMouseClicked

    private void pnlTaskListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTaskListMouseClicked
        // Remove all components from pnlMain
        pnlMain.removeAll();

        // Create an instance of DoneZo
        TaskList doneZo = new TaskList();

        // Add DoneZo to pnlMain and make it visible
        pnlMain.add(doneZo);
        doneZo.setVisible(true);

        // Refresh pnlMain
        pnlMain.revalidate();
        pnlMain.repaint();
    }//GEN-LAST:event_pnlTaskListMouseClicked

    private void pnlWorkflowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlWorkflowMouseClicked
        // TODO add your handling code here:
        Workflow workflow = new Workflow();
        pnlMain.removeAll();
        pnlMain.add(workflow).setVisible(true);
    }//GEN-LAST:event_pnlWorkflowMouseClicked

    private void pnlSettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSettingsMouseClicked
        // TODO add your handling code here:
        Settings settings = new Settings();
        pnlMain.removeAll();
        pnlMain.add(settings).setVisible(true);
    }//GEN-LAST:event_pnlSettingsMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconDashboard;
    private javax.swing.JLabel iconLogo;
    private javax.swing.JLabel iconProgress;
    private javax.swing.JLabel iconSettings;
    private javax.swing.JLabel iconTasklist;
    private javax.swing.JLabel iconTasks;
    private javax.swing.JLabel iconTime;
    private javax.swing.JLabel iconWorkflow;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCountImmediate;
    private javax.swing.JLabel lblCountLater;
    private javax.swing.JLabel lblCountStart;
    private javax.swing.JLabel lblDashboard;
    private javax.swing.JLabel lblGreeting;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblImmediate;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMascot;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblPriorities;
    private javax.swing.JLabel lblProgress;
    private javax.swing.JLabel lblProgressDone;
    private javax.swing.JLabel lblScheduleLater;
    private javax.swing.JLabel lblSettings;
    private javax.swing.JLabel lblStartEarly;
    private javax.swing.JLabel lblSummary;
    private javax.swing.JLabel lblTaskList;
    private javax.swing.JLabel lblTasks;
    private javax.swing.JLabel lblTasksRemaining;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTimeRemaining;
    private javax.swing.JLabel lblWorkflow;
    private javax.swing.JPanel pnlCalendar;
    private javax.swing.JPanel pnlDashboard;
    private javax.swing.JPanel pnlGreeting;
    private javax.swing.JDesktopPane pnlMain;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlPriorities;
    private javax.swing.JPanel pnlProgress;
    private javax.swing.JPanel pnlSettings;
    private javax.swing.JPanel pnlTaskList;
    private javax.swing.JPanel pnlTaskRemaining;
    private javax.swing.JPanel pnlTime;
    private javax.swing.JPanel pnlWorkflow;
    private com.mycompany.donezodraft.ProgressBar progressBar1;
    // End of variables declaration//GEN-END:variables
}
