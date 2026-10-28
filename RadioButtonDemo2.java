
package radiobuttondemo2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonDemo2 extends JFrame implements ActionListener {
    
    private JRadioButton birdButton, catButton, dogButton, rabbitButton, pigButton;
    private JLabel imageLabel;
    private ImageIcon birdIcon, catIcon, dogIcon, rabbitIcon, pigIcon;

    public RadioButtonDemo2() {
 
        setTitle("RadioButtonDemo");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        birdIcon = loadIcon("bird.jpg", "Bird");
        catIcon = loadIcon("cat.jpg", "Cat");
        dogIcon = loadIcon("dog.jpg", "Dog");
        rabbitIcon = loadIcon("rabbit.jpg", "Rabbit");
        pigIcon = loadIcon("pig.jpg", "Pig");

        birdButton = new JRadioButton("Bird");
        catButton = new JRadioButton("Cat");
        dogButton = new JRadioButton("Dog");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton = new JRadioButton("Pig", true); // Default selected

        ButtonGroup group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(5, 1, 5, 5));
        radioPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);

        imageLabel = new JLabel(pigIcon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        add(radioPanel, BorderLayout.WEST);
        add(imagePanel, BorderLayout.CENTER);

        birdButton.addActionListener(this);
        catButton.addActionListener(this);
        dogButton.addActionListener(this);
        rabbitButton.addActionListener(this);
        pigButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String petName = "";
        ImageIcon selectedIcon = null;

        if (e.getSource() == birdButton) {
            petName = "Bird";
            selectedIcon = birdIcon;
        } else if (e.getSource() == catButton) {
            petName = "Cat";
            selectedIcon = catIcon;
        } else if (e.getSource() == dogButton) {
            petName = "Dog";
            selectedIcon = dogIcon;
        } else if (e.getSource() == rabbitButton) {
            petName = "Rabbit";
            selectedIcon = rabbitIcon;
        } else if (e.getSource() == pigButton) {
            petName = "Pig";
            selectedIcon = pigIcon;
        }

      
        imageLabel.setIcon(selectedIcon);

        JOptionPane.showMessageDialog(this, 
                "You selected: " + petName, 
                ", Selection Made", 
                JOptionPane.INFORMATION_MESSAGE);
    }

   
    private ImageIcon loadIcon(String path, String description) {
    java.net.URL imgURL = getClass().getResource(path);
    if (imgURL != null) {
        ImageIcon originalIcon = new ImageIcon(imgURL);
        // Resize image to 150x150 pixels so it fits nicely in the window
        Image scaledImage = originalIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    } else {
        System.out.println("Could not find image: " + path);
        return new ImageIcon(); 
    }
}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RadioButtonDemo2().setVisible(true);
        });
    }
}
