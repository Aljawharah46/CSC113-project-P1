import javax.swing.*;
import java.awt.*;

public class ResultFrame extends JFrame {

    private JTextArea resultArea;

    public ResultFrame() {
        setTitle("Party Results");
        setSize(400, 400);
        setLocation(600, 150);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        resultArea = new JTextArea();
        resultArea.setColumns(30);
        resultArea.setRows(18);
        resultArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(resultArea);
        contentPane.add(scrollPane);
    }

    public void showResult(String text) {
        resultArea.setText(text);
        setVisible(true);
    }
}
