package csc331.frenchtoastmafia.entities;

import java.text.DecimalFormat;

public class Player {

    // Public to save time
    public String pos, name;
    public int gp, att, yds, lng, big, td, fum, lst, fd, cmp, inter, sack, syl, rec, tgts, yac = 0;
    public double avg, yds_g, cmp_percent, qbr, rtg = 0.0;

    public Player (String pos, String name) {

        DecimalFormat round = new DecimalFormat("#.#");

        // Position and Name
        this.pos = pos;
        this.name = name;

        // Shared Stats
        gp = 0;
        att = 0;
        yds = 0;
        avg = 0.0;
        fum = 0;
        lst = 0;
        fd = 0;
        lng = 0;
        big = 0;
        td = 0;
        yds_g = 0.0;


        // Passing Stats
        cmp = 0;
        cmp_percent = 0.0;
        inter = 0;
        sack = 0;
        syl = 0;
        qbr = 0.0;
        rtg = 0.0;

        // Receiving Stats
        rec = 0;
        tgts = 0;
        yac = 0;

    }

    public void resetStats() {

        // Shared Stats
        gp = 0;
        att = 0;
        yds = 0;
        avg = 0.0;
        fum = 0;
        lst = 0;
        fd = 0;
        lng = 0;
        big = 0;
        td = 0;
        yds_g = 0.0;

        // Passing Stats
        cmp = 0;
        cmp_percent = 0.0;
        inter = 0;
        sack = 0;
        syl = 0;
        qbr = 0.0;
        rtg = 0.0;

        // Receiving Stats
        rec = 0;
        tgts = 0;
        yac = 0;

    }

    public void addGP(int gp) {
        this.gp = this.gp + gp;
    }

    public void addATT(int att) {
        this.att = this.att + att;
    }

    public void addYDS(int yds) {
        this.yds = this.yds + yds;
    }

    public void addAVG(double avg) {
        DecimalFormat round = new DecimalFormat("#.#");
        this.avg = Double.parseDouble(round.format(this.avg + avg));
    }

    public void addFUM(int fum) {
        this.fum = this.fum + fum;
    }

    public void addLST(int lst) {
        this.lst = this.lst + lst;
    }

    public void addFD(int fd) {
        this.fd = this.fd + fd;
    }

    public void addLNG(int lng) {
        this.lng = this.lng + lng;
    }

    public void addBIG(int big) {
        this.big = this.big + big;
    }

    public void addTD(int td) {
        this.td = this.td + td;
    }

    public void addYDS_G(double yds_g) {
        DecimalFormat round = new DecimalFormat("#.#");
        this.yds_g = Double.parseDouble(round.format(this.yds_g + yds_g));
    }

    public void addCMP(int cmp) {
        this.cmp = this.cmp + cmp;
    }

    public void addCMP_Percent(double cmp_percent) {
        DecimalFormat round = new DecimalFormat("#.#");
        this.cmp_percent = Double.parseDouble(round.format(this.cmp_percent + cmp_percent));
    }

    public void addINT(int inter) {
        this.inter = this.inter + inter;
    }

    public void addSACK(int sack) {
        this.sack = this.sack + sack;
    }

    public void addSYL(int syl) {
        this.syl = this.syl + syl;
    }

    public void addQBR(double qbr) {
        DecimalFormat round = new DecimalFormat("#.#");
        this.qbr = Double.parseDouble(round.format(this.qbr + qbr));
    }

    public void addRTG(double rtg) {
        DecimalFormat round = new DecimalFormat("#.#");
        this.rtg = Double.parseDouble(round.format(this.rtg + rtg));
    }

    public void addREC(int rec) {
        this.rec = this.rec + rec;
    }

    public void addTGTS(int tgts) {
        this.tgts = this.tgts + tgts;
    }

    public void addYAC(int yac) {
        this.yac = this.yac + yac;
    }
}
