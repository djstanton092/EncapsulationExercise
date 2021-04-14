package com.djstanton;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        if (tonerLevel > -1 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        } else {
            this.tonerLevel = -1;
        }

        this.duplex = duplex;
        this.pagesPrinted = 0;
    }

    public int addToner(int tonerAmount) {
        if (tonerAmount > 0 && tonerAmount <= 100) {
            if (tonerAmount + this.tonerLevel > 100) {
                return -1;
            }
            this.tonerLevel += tonerAmount;
        }

        return this.tonerLevel;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }

    public int printPages(int pages){
        if (this.duplex) {
            System.out.println("Printing in duplex mode");
        }
        int pagesToPrint = (duplex)? ((pages / 2) + (pages % 2) ) :pages;

        this.pagesPrinted += pagesToPrint;

        return this.getPagesPrinted();
    }


}
