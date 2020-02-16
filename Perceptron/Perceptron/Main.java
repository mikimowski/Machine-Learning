import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static final int numberOfSamples = 768;
    private static final int numberOfTestsSamples = 200;
    private static final int numberOfFeatures = 8;
    private static final int numberOfTrainingSamples = numberOfSamples - numberOfTestsSamples;

    public static void main(String[] args) {
        String CSVFile = "../data/data.csv";
        String line = "";
        String cvsSplitBy = ",";

        int cnt_good = 0, prediction, counter = 0;
        Perceptron perceptron = new Perceptron(numberOfFeatures);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(CSVFile))) {
            Double[] vector_input = new Double[numberOfFeatures];
            while ((line = bufferedReader.readLine()) != null) {
                String[] string_vector = line.split(cvsSplitBy);

                if (counter < numberOfTrainingSamples) {
                    for (int i = 0; i < vector_input.length; i++)
                        vector_input[i] = Double.valueOf(string_vector[i]);
                    int output = Integer.valueOf(string_vector[numberOfFeatures]);

                    perceptron.train(vector_input, output);
                } else {
                    for (int i = 0; i < vector_input.length; i++)
                        vector_input[i] = Double.valueOf(string_vector[i]);
                    prediction = perceptron.feedForward(vector_input);
                    if (Integer.valueOf(string_vector[numberOfFeatures]) == prediction)
                        cnt_good++;
                }
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Result: " + cnt_good + "/" + numberOfTestsSamples + " which is: " + (cnt_good * 100) / numberOfTestsSamples + "%");
    }
}
