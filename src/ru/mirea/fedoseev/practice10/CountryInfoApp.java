package ru.mirea.fedoseev.practice10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountryInfoApp extends JFrame {
    private JComboBox<String> countryComboBox;
    private JTextArea infoTextArea;

    public CountryInfoApp() {
        setTitle("Hello Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(400, 300);

        // Создаем ComboBox со странами
        String[] countries = {"Australia", "China", "England", "Russia"};
        countryComboBox = new JComboBox<>(countries);
        countryComboBox.addActionListener(new CountrySelectionListener());

        // Создаем текстовую область для информации
        infoTextArea = new JTextArea();
        infoTextArea.setEditable(false);
        infoTextArea.setLineWrap(true);
        infoTextArea.setWrapStyleWord(true);
        infoTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        infoTextArea.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(infoTextArea);

        // Добавляем компоненты
        add(countryComboBox, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Отображаем информацию о первой стране
        updateCountryInfo((String) countryComboBox.getSelectedItem());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateCountryInfo(String country) {
        String info = "";
        switch (country) {
            case "Australia":
                info = "Australia is a country and continent surrounded by the Indian and Pacific oceans. " +
                       "Its major cities – Sydney, Brisbane, Melbourne, Perth, Adelaide – are coastal. " +
                       "Its capital, Canberra, is inland. The country is known for its Sydney Opera House, " +
                       "the Great Barrier Reef, a vast interior desert wilderness called the Outback, " +
                       "and unique animal species like kangaroos and duck-billed platypuses.";
                break;
            case "China":
                info = "China is a populous nation in East Asia whose vast landscape encompasses " +
                       "grassland, desert, mountains, lakes, rivers and more than 14,000km of coastline. " +
                       "Capital Beijing mixes modern architecture with historic sites such as the Forbidden City palace complex " +
                       "and Tiananmen Square. Shanghai is a skyscraper-studded global financial center. " +
                       "The iconic Great Wall of China runs east-west across northern China.";
                break;
            case "England":
                info = "England is a country that is part of the United Kingdom. " +
                       "It shares land borders with Wales to its west and Scotland to its north. " +
                       "The Irish Sea lies northwest of England and the Celtic Sea to the southwest. " +
                       "England is separated from continental Europe by the North Sea to the east and the English Channel to the south. " +
                       "The capital is London, which is the largest metropolitan area in both the United Kingdom and the European Union.";
                break;
            case "Russia":
                info = "Russia is the world's largest nation with a rich history and diverse culture. " +
                       "It extends across the whole of northern Asia and the eastern third of Europe, " +
                       "spanning eleven time zones and incorporating a great range of environments and landforms. " +
                       "The capital city is Moscow, and the country is known for its contributions to art, literature, " +
                       "music, ballet, architecture and science. Famous landmarks include the Kremlin, Red Square, and Saint Basil's Cathedral.";
                break;
        }
        infoTextArea.setText(info);
    }

    private class CountrySelectionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedCountry = (String) countryComboBox.getSelectedItem();
            updateCountryInfo(selectedCountry);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CountryInfoApp();
            }
        });
    }
}
