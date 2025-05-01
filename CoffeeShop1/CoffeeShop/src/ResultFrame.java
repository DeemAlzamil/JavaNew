import javax.swing.*;
import java.awt.*;

public class ResultFrame extends JFrame {

    public ResultFrame(String resultText) {
        setTitle("Search Result");
        setSize(400, 200);
        setLayout(new BorderLayout());

        JTextArea resultArea = new JTextArea(resultText);
        resultArea.setEditable(false);

        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        setVisible(true);
    }
}
