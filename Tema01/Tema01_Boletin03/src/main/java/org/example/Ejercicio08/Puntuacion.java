package org.example.Ejercicio08;

import java.util.Objects;

public class Puntuacion {
    private double imdb;
    private double rt;
    private double media;

    public Puntuacion(double imdb, int rt) {
        this.imdb = imdb;
        this.rt = normalizar(rt);
        media = mediaPuntuacion(imdb,rt);
    }

    public double getImdb() {
        return imdb;
    }

    public void setImdb(double imdb) {
        this.imdb = imdb;
    }

    public double getRt() {
        return rt;
    }

    public void setRt(int rt) {
        this.rt = normalizar(rt);
    }
    private double normalizar(int rt) {
        return (double) (rt/10);
    }
    private double mediaPuntuacion(double imdb,double rt){
        return (imdb + ((double)rt/10))/2;
    }
    public double getMedia() {
        return media;
    }

    @Override
    public String toString() {
        return "Puntuacion{" +
                "imdb=" + imdb +
                ", rt=" + rt +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Puntuacion that = (Puntuacion) o;
        return Double.compare(imdb, that.imdb) == 0 && Double.compare(rt, that.rt) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(imdb, rt);
    }
}
