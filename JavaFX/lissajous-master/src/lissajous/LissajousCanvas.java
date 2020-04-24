/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lissajous;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 *
 * @author tiwi
 */
public class LissajousCanvas extends Canvas {

    private final LissajousData data;
    private static final int AANT_PTN = 200;
    private static final int RAND = 5;
    private final GraphicsContext gc;
    private final int factor;
    private Color kleurAs;
    private ContextMenu menu;

    public LissajousCanvas(LissajousData data, double width, double height) {
        super(width, height);
        this.data = data;
        gc = this.getGraphicsContext2D();
        factor = Math.min((int) getWidth(), (int) getHeight()) - 2 * RAND;
        kleurAs = Color.RED;
        tekenAssen();
        getStyleClass().add("canvas");
        maakContextMenu();
        LissajousCanvas canvas = this;
        addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        if (e.getButton() == MouseButton.SECONDARY) {
                            menu.show(canvas, e.getScreenX(), e.getScreenY());
                        }
                    }
                });
    }

    private void tekenAssen() {
        gc.setStroke(kleurAs);
        gc.strokeLine(0, factor / 2 + RAND, factor + 2 * RAND, factor / 2 + RAND);
        gc.strokeLine(factor / 2 + RAND, 0, factor / 2 + RAND, factor + 2 * RAND);
    }

    private void tekenFiguur() {
        int A = data.getVertFreq();
        int B = data.getHorizFreq();
        int fGraden = data.getFazeVerschil();
        if (A != LissajousData.HF_DEF && B != LissajousData.VF_DEF && fGraden != LissajousData.F_DEF) {
            double f = Math.PI * fGraden / 180;
            double[] x = new double[AANT_PTN];
            double[] y = new double[AANT_PTN];
            for (int i = 0; i < AANT_PTN; i++) {
                x[i] = RAND + factor / 2 * (1 + Math.sin(i * A * 2 * Math.PI / AANT_PTN));
                y[i] = RAND + factor / 2 * (1 - Math.sin(f + (i * B * 2 * Math.PI / AANT_PTN)));
            }
            gc.setStroke(Color.BLACK);
            gc.strokePolygon(x, y, x.length);
        }
    }

    public void teken() {
        gc.clearRect(0, 0, factor + 2 * RAND, factor + 2 * RAND);
        tekenAssen();
        tekenFiguur();
    }

    public void setKleurAs(Color kleur) {
        kleurAs = kleur;
        teken();
    }

    public Color getKleurAs() {
        return kleurAs;
    }

    private void maakContextMenu() {
        menu = new ContextMenu();
        MenuItem item = new MenuItem("Kleur Assen");
        LissajousCanvas canvas = this;
        item.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                new KiesKleur(canvas).show();
            }
        });
        menu.getItems().add(item);
    }

}
