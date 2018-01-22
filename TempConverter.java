import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TempConverter {

	private JFrame frame;
	private JTextField textFieldCelsius;
	private JTextField textFieldFahrenheit;
	private double temperatureCelsius;
	private double temperatureFahrenheit;
	
	
	public void setCelius(double tempCelsius) {
		temperatureCelsius = tempCelsius;
	}
	
	public double getCelsius() {
		return temperatureCelsius;
	}
	
	public void setFahrenheit(double tempFahrenheit) {
		temperatureFahrenheit = tempFahrenheit;
	}
	
	public double getFahrenheit() {
		return temperatureFahrenheit;
	}
	
	public double convertToCelsius(double tempFahrenheit) {
		tempFahrenheit = temperatureFahrenheit;
		double tempToCelsius = (((tempFahrenheit -32) * 5)/9);
		return tempToCelsius;
	}
	
	public double convertToFahrenheit(double tempCelsius) {
		tempCelsius = temperatureCelsius;
		double tempToFahrenheit = ((tempCelsius * 9/5) + 32);
		return tempToFahrenheit;
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TempConverter window = new TempConverter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TempConverter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 406, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldCelsius = new JTextField();
		textFieldCelsius.setText("0.00");
		textFieldCelsius.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				textFieldFahrenheit.setText("32.00");
			}
		});
		
		textFieldCelsius.setBounds(27, 91, 160, 20);
		frame.getContentPane().add(textFieldCelsius);
		textFieldCelsius.setColumns(10);
		
		textFieldFahrenheit = new JTextField();
		textFieldFahrenheit.setText("32.00");
		textFieldFahrenheit.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldCelsius.setText("0.00");
			}
		});
		textFieldFahrenheit.setBounds(27, 136, 160, 20);
		frame.getContentPane().add(textFieldFahrenheit);
		textFieldFahrenheit.setColumns(10);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String inputCelsius = textFieldCelsius.getText();
				String inputFahrenheit = textFieldFahrenheit.getText();
				
				TempConverter obj1 = new TempConverter();
				double newCelsius = Double.parseDouble(inputCelsius);
				double newFahrenheit = Double.parseDouble(inputFahrenheit);
				
				if (newFahrenheit == 0.00) {
					obj1.setCelius(newCelsius);
					String s1 = Double.toString(obj1.convertToFahrenheit(getCelsius()));
					textFieldFahrenheit.setText(s1);
					
				}
				
				if (newCelsius == 0.00) {
					obj1.setFahrenheit(newFahrenheit);
					String s1 = Double.toString(obj1.convertToCelsius(getFahrenheit()));
					textFieldCelsius.setText(s1);
					
				}
				
			}
		});
		btnConvert.setBounds(134, 199, 132, 41);
		frame.getContentPane().add(btnConvert);
		
		JLabel lblTemperatureConverter = new JLabel("Temperature Converter");
		lblTemperatureConverter.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 23));
		lblTemperatureConverter.setForeground(Color.BLUE);
		lblTemperatureConverter.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemperatureConverter.setBounds(51, 11, 276, 48);
		frame.getContentPane().add(lblTemperatureConverter);
		
		JLabel lblCelsius = new JLabel("Celsius");
		lblCelsius.setBounds(197, 94, 46, 14);
		frame.getContentPane().add(lblCelsius);
		
		JLabel lblFarenheit = new JLabel("Fahrenheit");
		lblFarenheit.setBounds(197, 139, 71, 14);
		frame.getContentPane().add(lblFarenheit);
	}
}
