package TrabalhoCurso;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TesteDengue {
    private JFrame frame;
    private JPanel panel;
    private JButton yesButton;
    private JButton noButton;
    private JLabel label;
    private String[] questions = {
    		"Você tem febre alta (39-40°C) que começou de repente?",
            "Você está sentindo dores de cabeça intensas?",
            "Você sente dor atrás dos olhos?",
            "Você está sentindo dores musculares e articulares intensas?",
            "Você tem manchas vermelhas na pele (exantema)?",
            "Você está sentindo náuseas ou teve vômitos recentemente?",
            "Você tem dor abdominal intensa e contínua?",
            "Você notou sangramentos (por exemplo, sangramento nasal, gengival ou manchas roxas na pele)?",
            "Você sente fadiga e fraqueza intensas?",
            "Você tem inchaço nas extremidades (mãos e pés)?"
    };
    private int questionIndex = 0;
    private int score = 0;

    public TesteDengue() {
        frame = new JFrame("Teste de Dengue");
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        yesButton = new JButton("Sim");
        noButton = new JButton("Não");
        label = new JLabel(questions[questionIndex]);
        
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                score++;
                nextQuestion();
            }
        });

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextQuestion();
            }
        });

        panel.add(label);
        panel.add(yesButton);
        panel.add(noButton);
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void nextQuestion() {
        questionIndex++;
        if (questionIndex < questions.length) {
            label.setText(questions[questionIndex]);
        } else {
            label.setText("<html>Resultado: " + (score > 5 ? "Favor procurar uma unidade de saúde mais próxima, possível caso de dengue!" : "<div style='text-align: center;'>Diagnóstico não conclusivo para dengue<br>"
            + "Possível caso de outra enfermidade, em caso de persistência de alguns sintomas procurar unidade de saúde mais próxima!</div></html>"));
            yesButton.setEnabled(false);
            noButton.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        new TesteDengue();
    }
}

