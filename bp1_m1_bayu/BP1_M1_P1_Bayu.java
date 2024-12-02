package bp1_m1_bayu;

import java.awt.*;

public class BP1_M1_P1_Bayu extends Frame{
    public static void main (String[] args) {
        BP1_M1_P1_Bayu test = new BP1_M1_P1_Bayu();
    }

    public BP1_M1_P1_Bayu() {
        super("BP1_M1_P1_Bayu");
        setSize(300, 100);
        Panel panelTombol = new Panel();
        panelTombol.add (new Button ("Mulai"));
        panelTombol.add (new Button ("Selesai"));
        add ("South", panelTombol);

        show();
    }
}
