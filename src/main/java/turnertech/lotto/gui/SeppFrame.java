package turnertech.lotto.gui;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;

public class SeppFrame extends Frame {
    
    public SeppFrame() {
        this.setMinimumSize(new Dimension(200,200));
        this.setSize(500, 500);

        this.add(new Label("Hello!"));
        
    }

}
