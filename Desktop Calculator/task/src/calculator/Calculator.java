package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator extends JFrame {
    private final JLabel equationLabel;
    private final JLabel resultLabel;

    public Calculator() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 420);
        setLayout(null);
        setTitle("Calculator");


        equationLabel = new JLabel();
        equationLabel.setBounds(20, 100, 220, 30);
        equationLabel.setName("EquationLabel");
        equationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        equationLabel.setFont(new Font("courier", Font.PLAIN, 20));
        equationLabel.setForeground(new Color(0, 180, 0));
        add(equationLabel);

        resultLabel = new JLabel();
        resultLabel.setBounds(20, 40, 220, 30);
        resultLabel.setName("ResultLabel");
        resultLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        resultLabel.setFont(new Font("courier", Font.BOLD, 30));
        resultLabel.setText("0");
        add(resultLabel);

        JButton zeroButton = new JButton("0");
        zeroButton.setName("Zero");
        int buttonBaseY = 200;
        int buttonBaseX = 15;
        int buttonHeight = 30;
        int buttonYDistance = buttonHeight + 5;
        int buttonWidth = 60;
        int buttonXDistance = buttonWidth + 5;
        zeroButton.setBounds(buttonBaseX + buttonXDistance, buttonBaseY + 4 * buttonYDistance, buttonWidth, buttonHeight);
        zeroButton.addActionListener(this::addToEquation);
        zeroButton.setBackground(Color.WHITE.brighter());
        zeroButton.setBorderPainted(false);
        add(zeroButton);

        JButton oneButton = new JButton("1");
        oneButton.setName("One");
        oneButton.setBounds(buttonBaseX, buttonBaseY + 3 * buttonYDistance, buttonWidth, buttonHeight);
        oneButton.addActionListener(this::addToEquation);
        oneButton.setBackground(Color.WHITE.brighter());
        oneButton.setBorderPainted(false);
        add(oneButton);

        JButton twoButton = new JButton("2");
        twoButton.setName("Two");
        twoButton.setBounds(buttonBaseX + buttonXDistance, buttonBaseY + 3 * buttonYDistance, buttonWidth, buttonHeight);
        twoButton.addActionListener(this::addToEquation);
        twoButton.setBackground(Color.WHITE.brighter());
        twoButton.setBorderPainted(false);
        add(twoButton);

        JButton threeButton = new JButton("3");
        threeButton.setName("Three");
        threeButton.setBounds(buttonBaseX + 2 * buttonXDistance, buttonBaseY + 3 * buttonYDistance, buttonWidth, buttonHeight);
        threeButton.addActionListener(this::addToEquation);
        threeButton.setBackground(Color.WHITE.brighter());
        threeButton.setBorderPainted(false);
        add(threeButton);

        JButton fourButton = new JButton("4");
        fourButton.setName("Four");
        fourButton.setBounds(buttonBaseX, buttonBaseY + 2 * buttonYDistance, buttonWidth, buttonHeight);
        fourButton.addActionListener(this::addToEquation);
        fourButton.setBackground(Color.WHITE.brighter());
        fourButton.setBorderPainted(false);
        add(fourButton);

        JButton fiveButton = new JButton("5");
        fiveButton.setName("Five");
        fiveButton.setBounds(buttonBaseX + buttonXDistance, buttonBaseY + 2 * buttonYDistance, buttonWidth, buttonHeight);
        fiveButton.addActionListener(this::addToEquation);
        fiveButton.setBackground(Color.WHITE.brighter());
        fiveButton.setBorderPainted(false);
        add(fiveButton);

        JButton sixButton = new JButton("6");
        sixButton.setName("Six");
        sixButton.setBounds(buttonBaseX + 2 * buttonXDistance, buttonBaseY + 2 * buttonYDistance, buttonWidth, buttonHeight);
        sixButton.addActionListener(this::addToEquation);
        sixButton.setBackground(Color.WHITE.brighter());
        sixButton.setBorderPainted(false);
        add(sixButton);

        JButton sevenButton = new JButton("7");
        sevenButton.setName("Seven");
        sevenButton.setBounds(buttonBaseX, buttonBaseY + buttonYDistance, buttonWidth, buttonHeight);
        sevenButton.addActionListener(this::addToEquation);
        sevenButton.setBackground(Color.WHITE.brighter());
        sevenButton.setBorderPainted(false);
        add(sevenButton);

        JButton eightButton = new JButton("8");
        eightButton.setName("Eight");
        eightButton.setBounds(buttonBaseX + buttonXDistance, buttonBaseY + buttonYDistance, buttonWidth, buttonHeight);
        eightButton.addActionListener(this::addToEquation);
        eightButton.setBackground(Color.WHITE.brighter());
        eightButton.setBorderPainted(false);
        add(eightButton);

        JButton nineButton = new JButton("9");
        nineButton.setName("Nine");
        nineButton.setBounds(buttonBaseX + 2 * buttonXDistance, buttonBaseY + buttonYDistance, buttonWidth, buttonHeight);
        nineButton.addActionListener(this::addToEquation);
        nineButton.setBackground(Color.WHITE.brighter());
        nineButton.setBorderPainted(false);
        add(nineButton);

        JButton divideButton = new JButton("\u00F7");
        divideButton.setName("Divide");
        divideButton.setBounds(buttonBaseX + 3 * buttonXDistance, buttonBaseY, buttonWidth, buttonHeight);
        divideButton.addActionListener(this::addToEquation);
        divideButton.setBackground(new Color(160, 160, 160).brighter());
        divideButton.setBorderPainted(false);
        add(divideButton);

        JButton multiplyButton = new JButton("\u00D7");
        multiplyButton.setName("Multiply");
        multiplyButton.setBounds(buttonBaseX + 3 * buttonXDistance, buttonBaseY + buttonYDistance, buttonWidth, buttonHeight);
        multiplyButton.addActionListener(this::addToEquation);
        multiplyButton.setBackground(new Color(160, 160, 160).brighter());
        multiplyButton.setBorderPainted(false);
        add(multiplyButton);

        JButton addButton = new JButton("\u002B");
        addButton.setName("Add");
        addButton.setBounds(buttonBaseX + 3 * buttonXDistance, buttonBaseY + 2 * buttonYDistance, buttonWidth, buttonHeight);
        addButton.addActionListener(this::addToEquation);
        addButton.setBackground(new Color(160, 160, 160).brighter());
        addButton.setBorderPainted(false);
        add(addButton);

        JButton subtractButton = new JButton("-");
        subtractButton.setName("Subtract");
        subtractButton.setBounds(buttonBaseX + 3 * buttonXDistance, buttonBaseY + 3 * buttonYDistance, buttonWidth, buttonHeight);
        subtractButton.addActionListener(this::addToEquation);
        subtractButton.setBackground(new Color(160, 160, 160).brighter());
        subtractButton.setBorderPainted(false);
        add(subtractButton);

        JButton equalsButton = new JButton("=");
        equalsButton.setName("Equals");
        equalsButton.setBounds(buttonBaseX + 3 * buttonXDistance, buttonBaseY + 4 * buttonYDistance, buttonWidth, buttonHeight);
        equalsButton.addActionListener(this::parseTextAndCalculate);
        equalsButton.setBackground(new Color(160, 160, 160).brighter());
        equalsButton.setBorderPainted(false);
        add(equalsButton);

        JButton clearButton = new JButton("C");
        clearButton.setName("Clear");
        clearButton.setBounds(buttonBaseX + 2 * buttonXDistance, buttonBaseY - buttonYDistance, buttonWidth, buttonHeight);
        clearButton.addActionListener(this::clearLabels);
        clearButton.setBackground(new Color(160, 160, 160).brighter());
        clearButton.setBorderPainted(false);
        add(clearButton);

        JButton deleteButton = new JButton("Del");
        deleteButton.setName("Delete");
        deleteButton.setBounds(buttonBaseX + 3 * buttonXDistance, buttonBaseY - buttonYDistance, buttonWidth, buttonHeight);
        deleteButton.addActionListener(this::deleteLastChar);
        deleteButton.setBackground(new Color(160, 160, 160).brighter());
        deleteButton.setBorderPainted(false);
        add(deleteButton);

        JButton parenthesesButton = new JButton("()");
        parenthesesButton.setName("Parentheses");
        parenthesesButton.setBounds(buttonBaseX, buttonBaseY - buttonYDistance, buttonWidth, buttonHeight);
        parenthesesButton.addActionListener(this::addParentheses);
        parenthesesButton.setBackground(new Color(160, 160, 160).brighter());
        parenthesesButton.setBorderPainted(false);
        add(parenthesesButton);

        JButton clearEntryButton = new JButton("CE");
        clearEntryButton.setName("ClearEntry");
        clearEntryButton.setBounds(buttonBaseX + buttonXDistance, buttonBaseY - buttonYDistance, buttonWidth, buttonHeight);
        clearEntryButton.addActionListener(this::clearEntry);
        clearEntryButton.setBackground(new Color(160, 160, 160).brighter());
        clearEntryButton.setBorderPainted(false);
        add(clearEntryButton);

        JButton dotButton = new JButton(".");
        dotButton.setName("Dot");
        dotButton.setBounds(buttonBaseX + 2 * buttonXDistance, buttonBaseY + 4 * buttonYDistance, buttonWidth, buttonHeight);
        dotButton.addActionListener(this::addToEquation);
        dotButton.setBackground(Color.WHITE.brighter());
        dotButton.setBorderPainted(false);
        add(dotButton);

        JButton plusMinusButton = new JButton("\u00B1");
        plusMinusButton.setName("PlusMinus");
        plusMinusButton.setBounds(buttonBaseX, buttonBaseY + 4 * buttonYDistance, buttonWidth, buttonHeight);
        plusMinusButton.addActionListener(this::addPlusMinus);
        plusMinusButton.setBackground(Color.WHITE.brighter());
        plusMinusButton.setBorderPainted(false);
        add(plusMinusButton);

        JButton powerTwoButton = new JButton("X\u00B2");
        powerTwoButton.setName("PowerTwo");
        powerTwoButton.setBounds(buttonBaseX, buttonBaseY, buttonWidth, buttonHeight);
        powerTwoButton.addActionListener(this::addPowerTwo);
        powerTwoButton.setBackground(new Color(160, 160, 160).brighter());
        powerTwoButton.setBorderPainted(false);
        add(powerTwoButton);

        JButton powerYButton = new JButton("X\u02B8");
        powerYButton.setName("PowerY");
        powerYButton.setBounds(buttonBaseX + buttonXDistance, buttonBaseY, buttonWidth, buttonHeight);
        powerYButton.addActionListener(this::addPowerY);
        powerYButton.setBackground(new Color(160, 160, 160).brighter());
        powerYButton.setBorderPainted(false);
        add(powerYButton);

        JButton squareRootButton = new JButton("√");
        squareRootButton.setName("SquareRoot");
        squareRootButton.setBounds(buttonBaseX + 2 * buttonXDistance, buttonBaseY, buttonWidth, buttonHeight);
        squareRootButton.addActionListener(this::addSquareRoot);
        squareRootButton.setBackground(new Color(160, 160, 160).brighter());
        squareRootButton.setBorderPainted(false);
        add(squareRootButton);

        setVisible(true);
    }

    private void addPlusMinus(ActionEvent e) {
        String equation = equationLabel.getText();

        if (equation.isEmpty()) {
            equationLabel.setText("(-");
        } else if (equation.startsWith("(-")) {
            equationLabel.setText(equation.substring(2));
        } else {
            equationLabel.setText("(-" + equation);
        }
    }

    private void addParentheses(ActionEvent e) {
        String equation = equationLabel.getText();

        int nLeftParenthesis = getElementCount("(");
        int nRightParenthesis = getElementCount(")");

        if (nLeftParenthesis == nRightParenthesis) {
            equationLabel.setText(equation + "(");
        } else if (equation.matches(".*\\($") || equation.matches(".*[\u002B\u00D7\u00F7-]$")) {
            equationLabel.setText(equation + "(");
        } else {
            equationLabel.setText(equation + ")");
        }
    }

    private int getElementCount(String e) {
        ArrayList<String> equationArray = equationStringToArray();

        int nElement = 0;

        for (String element: equationArray) {
            if (e.equals(element)) {
                nElement++;
            }
        }

        return nElement;
    }

    private void addSquareRoot(ActionEvent e) {
        String equation = equationLabel.getText();

        if (equation.matches(".*[\u002B\u00D7\u00F7-]$") || equation.matches(".*\\)$") || equation.isEmpty()) {
            equationLabel.setText(equation + "√(");
        }
    }

    private void addPowerY(ActionEvent e) {
        String equation = equationLabel.getText();

        if (equation.isEmpty()) {
            return;
        }

        if (equation.endsWith(")") || equation.matches(".*[\\d.]*$")) {
            equationLabel.setText(equation + "^(");
        }
    }

    private void addPowerTwo(ActionEvent e) {
        String equation = equationLabel.getText();

        if (equation.isEmpty()) {
            return;
        }

        if (equation.endsWith(")") || equation.matches(".*[\\d.]*$")) {
            equationLabel.setText(equation + "^(2)");
        }
    }

    private void clearEntry(ActionEvent e) {
        equationLabel.setText("");
    }

    private void deleteLastChar(ActionEvent e) {
        String text = equationLabel.getText();

        if ("".equals(text)) {
            return;
        }
        equationLabel.setText(text.substring(0, text.length() - 1));
    }

    private void clearLabels(ActionEvent e) {
        equationLabel.setText("");
        resultLabel.setText("0");
    }

    private void parseTextAndCalculate(ActionEvent e) {
        ArrayList<String> infixEquation = equationStringToArray();

        if (infixEquation.get(infixEquation.size() - 1).matches("[\u002B\u00D7\u00F7-]")) {
            equationLabel.setForeground(Color.RED.darker());
            return;
        } else if (getElementCount("(") != getElementCount(")")) {
            equationLabel.setForeground(Color.RED.darker());
            return;
        }

        ArrayList<String> postfixEquation = infixToPostfix(infixEquation);

        double result = calculatePostfix(postfixEquation);

        setResult(result);
    }

    private double calculatePostfix(ArrayList<String> postfixEquation) {
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String element: postfixEquation) {
            if (element.matches("[\\d.]+")) {
                stack.push(element);
            } else if ("\u221A".equals(element)) {
                double val = Double.parseDouble(stack.pop());
                stack.push(String.valueOf(Math.sqrt(val)));
            } else if ("_".equals(element)) {
                double val = Double.parseDouble(stack.pop());
                stack.push(String.valueOf(-val));
            }else {
                double val1 = Double.parseDouble(stack.pop());
                double val2 = Double.parseDouble(stack.pop());

                switch (element) {
                    case "\u002B":
                        stack.push(String.valueOf(val2 + val1));
                        break;
                    case "-":
                        stack.push(String.valueOf(val2 - val1));
                        break;
                    case "\u00D7":
                        stack.push(String.valueOf(val2 * val1));
                        break;
                    case "\u00F7":
                        if (0 == val1) {
                            equationLabel.setForeground(Color.RED.darker());
                            return 0;
                        } else {
                            stack.push(String.valueOf(val2 / val1));
                        }
                        break;
                    case "^":
                        stack.push(String.valueOf(Math.pow(val2, val1)));

                }
            }
        }

        equationLabel.setForeground(new Color(0, 180, 0));

        return Double.parseDouble(stack.pop());
    }

    private ArrayList<String> infixToPostfix(ArrayList<String> infixEquation) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayList<String> postfixEquation = new ArrayList<>();

        for (String element : infixEquation) {
            //if scanned character is open bracket push it on stack
            if(element.matches("\\(")){
                stack.push(element);
            }
                //if scanned character is opened bracket pop all literals from stack till matching open bracket gets popped
            else if(element.matches("\\)"))
            {
                while(!"(".equals(stack.peek()))
                {
                    postfixEquation.add(stack.pop());
                }
                stack.pop();
            } else if (element.matches("[\u002B\u00D7\u00F7\u221A^_-]")) {
                if (stack.isEmpty()) {
                    stack.push(element);
                } else {
                    if (getPrecedenceValue(stack.peek()) >= getPrecedenceValue(element)) {
                        postfixEquation.add(stack.pop());
                        stack.push(element);
                    } else {
                        stack.push(element);
                    }
                }
            } else {
                postfixEquation.add(element);
            }
        }

        while (!stack.isEmpty()) {
            postfixEquation.add(stack.pop());
        }
        return postfixEquation;
    }

    private int getPrecedenceValue(String operand) {
        if ("\u002B".equals(operand) || "-".equals(operand)) {
            return 1;
        } else if ("\u00D7".equals(operand) || "\u00F7".equals(operand)) {
            return 2;
        } else if ("\u221A".equals(operand)) {
            return 3;
        } else if ("^".equals(operand)) {
            return 4;
        } else if ("_".equals(operand)) {
            return 5;
        } else {
            return 0;
        }
    }

    private ArrayList<String> equationStringToArray() {
        String equation = equationLabel.getText();
        Matcher matcher = Pattern.compile("([\\d.]+|[\\u221A\\u00D7\\u002B\\u00F7^()-])").matcher(equation);

        ArrayList<String> output = new ArrayList<>();
        while (matcher.find()) {
            String match = matcher.group();
            if (output.size() != 0 && "(-".equals(output.get(output.size() - 1) + match)) {
                output.add("_");
            } else {
                output.add(match);
            }
        }

        return output;
    }

    private void setResult(double result) {
        if (result % 1 > 0) {
            resultLabel.setText(String.valueOf(result));
        } else {
            resultLabel.setText(String.valueOf(result).split("\\.")[0]);
        }
    }

    private void addToEquation(ActionEvent e) {
        JButton src = (JButton) e.getSource();
        String text = src.getText();
        String equation = equationLabel.getText();

        if (equation.isEmpty()) {
            if (text.matches("[\\d.]+")) {
                equationLabel.setText(text);
            }
        } else if (text.matches("[\u002B\u00D7\u00F7-]")) {
            ArrayList<String> infixEquation = equationStringToArray();

            String lastElement = infixEquation.get(infixEquation.size() - 1);
            if (lastElement.matches("\\.\\d+")) {
                equation = equation.replaceAll(lastElement, 0 + lastElement);
                equationLabel.setText(equation + text);
            } else if (lastElement.matches("\\d+\\.")) {
                equation = equation.replaceAll(lastElement, lastElement + 0);
                equationLabel.setText(equation + text);
            } else if (lastElement.matches("[\u002B\u00D7\u00F7-]")) {
                equation = equation.substring(0, equation.length() - 1) + text;
                equationLabel.setText(equation);
            } else {
                equationLabel.setText(equation + text);
            }
        } else {
            equationLabel.setText(equation + text);
        }
    }
}
