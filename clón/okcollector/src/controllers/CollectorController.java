/*
 * File: CollectorController.java
 * Created Date: 2021-09-24 10:42:41
 * Author: Sallai Andras
 * Github: https://github.com/andteki
 * -----
 * Last Modified: 2021-11-21
 * Modified By: Szilágyi Nikolett
 * -----
 * Copyright (c) 2021 Sallai Andras
 * 
 * GNU GPL v2
 */

package controllers;

import java.util.ArrayList;

import models.Page;
import views.MainWindow;

package controllers;

public class CollectorController {

    MainWindow mainWindow;

    // TODO: split into methods

    public CollectorController(MainWindow mainWindow) {

        this.mainWindow = mainWindow;

        setActionEvents();
    }

    private void setActionEvents() {

        mainWindow.pasteButton.addActionListener(event -> {

            mainWindow.urlField.paste();
        });

        mainWindow.startButton.addActionListener(event -> startButtonEvent());

        this.mainWindow.aboutButton.addActionListener(event -> {
            mainWindow.statusBar.setText("Szilágyi Nikolett | Szoft-2-N | 2022.11.21");
        });

        this.mainWindow.exitButton.addActionListener(event -> {
            System.exit(0);
        });
    }

    private void startButtonEvent() {

        String URL = mainWindow.urlField.getText();

        Page page = new Page();

        if (checkUrl.isValidUrl(URL)) {
            page.setUrl(URL);
        } else {
            mainWindow.statusBar.setText("Hibás url");
        }

        ArrayList<String> words = page.getContent();

        for (String word : words) {
            if (mainWindow.wordsModel.indexOf(word) < 0) {
                mainWindow.wordsModel.addElement(word);
            }
        }

        Integer wordCount = mainWindow.wordsModel.getSize();
        mainWindow.statusBar.setText("Szavak: " + wordCount.toString());

    }
}