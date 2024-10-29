package GUI;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JDialog;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import swing.shadow.ShadowRenderer;

public class Notification extends javax.swing.JComponent {

    private JDialog dialog;
    private Animator animator;
    private final Frame fram;
    private boolean showing;
    private Thread thread;
    private int animate = 10;
    private BufferedImage imageShadow;
    private int shadowSize = 6;
    private Type type;
    private Location location;

    public Notification(Frame fram, Type type, Location location, String message) {
        this.fram = fram;
        this.type = type;
        this.location = location;
        initComponents();
        init(message);
        initAnimator();
    }

    private void init(String message) {
        setBackground(Color.WHITE);
        dialog = new JDialog(fram);
        dialog.setUndecorated(true);
        dialog.setFocusableWindowState(false);
        dialog.setBackground(new Color(0, 0, 0, 0));
        dialog.add(this);
        dialog.setSize(getPreferredSize());
//        if (type == Type.SUCCESS) {
//            lbIcon.setIcon(new javax.swing.ImageIcon("C:\\Apache NetBeansProjects\\SistemaVentaMaven\\src\\main\\resources\\Img\\sucess.png"));
//            lbMessage.setText("Success");
//        } else if (type == Type.INFO) {
//            lbIcon.setIcon(new javax.swing.ImageIcon("C:\\Apache NetBeansProjects\\SistemaVentaMaven\\src\\main\\resources\\Img\\info.png"));
//            lbMessage.setText("Info");
//        } else {
//            lbIcon.setIcon(new javax.swing.ImageIcon("C:\\Apache NetBeansProjects\\SistemaVentaMaven\\src\\main\\resources\\Img\\warning.png"));
//            lbMessage.setText("Warning");
//        }
        switch (type) {
            case SUCCESS:
                lbIcon.setIcon(new javax.swing.ImageIcon("C:\\Apache NetBeansProjects\\SistemaVentaMaven\\src\\main\\resources\\Img\\sucess.png"));
                lbMessage.setText("Success");
                break;

            case INFO:
                lbIcon.setIcon(new javax.swing.ImageIcon("C:\\Apache NetBeansProjects\\SistemaVentaMaven\\src\\main\\resources\\Img\\info.png"));
                lbMessage.setText("Info");
                break;

            case WARNING:
                lbIcon.setIcon(new javax.swing.ImageIcon("C:\\Apache NetBeansProjects\\SistemaVentaMaven\\src\\main\\resources\\Img\\warning.png"));
                lbMessage.setText("Warning");
                break;
        }
        lbMessageText.setText(message);
    }

    private void initAnimator() {
        TimingTarget target = new TimingTargetAdapter() {
            private int x;
            private int top;
            private boolean top_to_bot;

            @Override
            public void timingEvent(float fraction) {
                if (showing) {
                    float alpha = 1f - fraction;
                    int y = (int) ((1f - fraction) * animate);
                    if (top_to_bot) {
                        dialog.setLocation(x, top + y);
                    } else {
                        dialog.setLocation(x, top - y);
                    }
                    dialog.setOpacity(alpha);
                } else {
                    float alpha = fraction;
                    int y = (int) (fraction * animate);
                    if (top_to_bot) {
                        dialog.setLocation(x, top + y);
                    } else {
                        dialog.setLocation(x, top - y);
                    }
                    dialog.setOpacity(alpha);
                }
            }

            @Override
            public void begin() {
                if (!showing) {
                    dialog.setOpacity(0f);
                    int margin = 10;
                    int y = 0;
//                    if (location == Location.TOP_CENTER) {
//                        x = fram.getX() + ((fram.getWidth() - dialog.getWidth()) / 2);
//                        y = fram.getY();
//                        top_to_bot = true;
//                    } else if (location == Location.TOP_RIGHT) {
//                        x = fram.getX() + fram.getWidth() - dialog.getWidth() - margin;
//                        y = fram.getY();
//                        top_to_bot = true;
//                    } else if (location == Location.TOP_LEFT) {
//                        x = fram.getX() + margin;
//                        y = fram.getY();
//                        top_to_bot = true;
//                    } else if (location == Location.BOTTOM_CENTER) {
//                        x = fram.getX() + ((fram.getWidth() - dialog.getWidth()) / 2);
//                        y = fram.getY() + fram.getHeight() - dialog.getHeight();
//                        top_to_bot = false;
//                    } else if (location == Location.BOTTOM_RIGHT) {
//                        x = fram.getX() + fram.getWidth() - dialog.getWidth() - margin;
//                        y = fram.getY() + fram.getHeight() - dialog.getHeight();
//                        top_to_bot = false;
//                    } else if (location == Location.BOTTOM_LEFT) {
//                        x = fram.getX() + margin;
//                        y = fram.getY() + fram.getHeight() - dialog.getHeight();
//                        top_to_bot = false;
//                    } else {
//                        x = fram.getX() + ((fram.getWidth() - dialog.getWidth()) / 2);
//                        y = fram.getY() + ((fram.getHeight() - dialog.getHeight()) / 2);
//                        top_to_bot = true;
//                    }
                    switch (location) {
                        case TOP_CENTER:
                            x = fram.getX() + ((fram.getWidth() - dialog.getWidth()) / 2);
                            y = fram.getY();
                            top_to_bot = true;
                            break;
                        case TOP_LEFT:
                            x = fram.getX() + margin;
                            y = fram.getY();
                            top_to_bot = true;
                            break;
                        case TOP_RIGHT:
                            x = fram.getX() + fram.getWidth() - dialog.getWidth() - margin;
                            y = fram.getY();
                            top_to_bot = true;
                            break;
                        case CENTER:
                            x = fram.getX() + ((fram.getWidth() - dialog.getWidth()) / 2);
                            y = fram.getY() + ((fram.getHeight() - dialog.getHeight()) / 2);
                            top_to_bot = true;
                            break;
                        case BOTTOM_CENTER:
                            x = fram.getX() + ((fram.getWidth() - dialog.getWidth()) / 2);
                            y = fram.getY() + fram.getHeight() - dialog.getHeight();
                            top_to_bot = false;
                            break;
                        case BOTTOM_LEFT:
                            x = fram.getX() + margin;
                            y = fram.getY() + fram.getHeight() - dialog.getHeight();
                            top_to_bot = false;
                            break;
                        case BOTTOM_RIGHT:
                            x = fram.getX() + fram.getWidth() - dialog.getWidth() - margin;
                            y = fram.getY() + fram.getHeight() - dialog.getHeight();
                            top_to_bot = false;
                            break;
                    }
                    top = y;
                    dialog.setLocation(x, y);
                    dialog.setVisible(true);
                }
            }

            @Override
            public void end() {
                showing = !showing;
                if (showing) {
                    thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            sleep();
                            closeNotification();
                        }
                    });
                    thread.start();
                } else {
                    dialog.dispose();
                }
            }
        };
        animator = new Animator(500, target);
        animator.setResolution(5);
    }

    public void showNotification() {
        animator.start();
    }

    private void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.drawImage(imageShadow, 0, 0, null);
        int x = shadowSize;
        int y = shadowSize;
        int width = getWidth() - shadowSize * 2;
        int height = getHeight() - shadowSize * 2;
        g2.fillRect(x, y, width, height);
//        if (type == Type.SUCCESS) {
//            g2.setColor(new Color(18, 163, 24));
//        } else if (type == Type.INFO) {
//            g2.setColor(new Color(28, 139, 206));
//        } else {
//            g2.setColor(new Color(241, 196, 15));
//        }
        switch (type) {
            case SUCCESS:
                g2.setColor(new Color(18, 163, 24));
                break;
            case INFO:
                g2.setColor(new Color(28, 139, 206));
                break;
            case WARNING:
                g2.setColor(new Color(241, 196, 15));
                break;
        }
        g2.fillRect(6, 5, 5, getHeight() - shadowSize * 2 + 1);
        g2.dispose();
        super.paint(grphcs);
    }

    private void closeNotification() {
        if (thread != null && thread.isAlive()) {
            thread.interrupt();
        }
        if (animator.isRunning()) {
            if (!showing) {
                animator.stop();
                showing = true;
                animator.start();
            }
        } else {
            showing = true;
            animator.start();
        }
    }

    @Override
    public void setBounds(int i, int i1, int i2, int i3) {
        super.setBounds(i, i1, i2, i3);
        creatImageShadow();

    }

    private void creatImageShadow() {
        imageShadow = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = imageShadow.createGraphics();
        g2.drawImage(createShadow(), 0, 0, null);
        g2.dispose();
    }

    private BufferedImage createShadow() {
        BufferedImage img = new BufferedImage(getWidth() - shadowSize * 2, getHeight() - shadowSize * 2, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.fillRect(0, 0, img.getWidth(), img.getHeight());
        g2.dispose();
        return new ShadowRenderer(shadowSize, 0.3f, new Color(100, 100, 100)).createShadow(img);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        lbMessage = new javax.swing.JLabel();
        lbMessageText = new javax.swing.JLabel();
        cmdClose = new javax.swing.JButton();

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcon.setIcon(new javax.swing.ImageIcon("C:\\Apache NetBeansProjects\\Bancario\\src\\main\\resources\\Iconos\\sucess.png")); // NOI18N

        panel.setOpaque(false);

        lbMessage.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbMessage.setForeground(new java.awt.Color(38, 38, 38));
        lbMessage.setText("Mensaje");

        lbMessageText.setForeground(new java.awt.Color(127, 127, 127));
        lbMessageText.setText("Mensaje text");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMessageText, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lbMessageText, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        cmdClose.setIcon(new javax.swing.ImageIcon("C:\\Apache NetBeansProjects\\Bancario\\src\\main\\resources\\Iconos\\close (1).png")); // NOI18N
        cmdClose.setBorder(null);
        cmdClose.setContentAreaFilled(false);
        cmdClose.setFocusable(false);
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbIcon)
                .addGap(2, 2, 2)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdClose, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed
        closeNotification();
    }//GEN-LAST:event_cmdCloseActionPerformed

    public static enum Type {
        SUCCESS, INFO, WARNING
    }

    public static enum Location {
        TOP_CENTER, TOP_RIGHT, TOP_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT, BOTTOM_LEFT, CENTER
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdClose;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JLabel lbMessageText;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables

}
