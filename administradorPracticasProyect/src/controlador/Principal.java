/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.PanelLogin;

/**
 *
 * @author LinkA
 */
public class Principal {
    public static void main(String[] args) {
        new PanelLogin().setVisible(true);
    }
}
