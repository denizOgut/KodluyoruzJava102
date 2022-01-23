package Model;

import java.util.Date;
import java.util.HashMap;

public class Room {
    private int yatakSayısı,metreKare;
    private boolean tv,miniBar,oyunKonsolu,kasa,projeksiyon;
    private Date enterDate, exitDate;


    public Room() {
    }

    public Room(int yatakSayısı, int metreKare, boolean tv, boolean miniBar, boolean oyunKonsolu, boolean kasa, boolean projeksiyon,Date enterDate,Date exitDate) {
        this.yatakSayısı = yatakSayısı;
        this.metreKare = metreKare;
        this.tv = tv;
        this.miniBar = miniBar;
        this.oyunKonsolu = oyunKonsolu;
        this.kasa = kasa;
        this.projeksiyon = projeksiyon;
        this.enterDate = enterDate;
        this.exitDate = exitDate;

    }

    public int getYatakSayısı() {
        return yatakSayısı;
    }

    public void setYatakSayısı(int yatakSayısı) {
        this.yatakSayısı = yatakSayısı;
    }

    public int getMetreKare() {
        return metreKare;
    }

    public void setMetreKare(int metreKare) {
        this.metreKare = metreKare;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isMiniBar() {
        return miniBar;
    }

    public void setMiniBar(boolean miniBar) {
        this.miniBar = miniBar;
    }

    public boolean isOyunKonsolu() {
        return oyunKonsolu;
    }

    public void setOyunKonsolu(boolean oyunKonsolu) {
        this.oyunKonsolu = oyunKonsolu;
    }

    public boolean isKasa() {
        return kasa;
    }

    public void setKasa(boolean kasa) {
        this.kasa = kasa;
    }

    public boolean isProjeksiyon() {
        return projeksiyon;
    }

    public void setProjeksiyon(boolean projeksiyon) {
        this.projeksiyon = projeksiyon;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }
}
