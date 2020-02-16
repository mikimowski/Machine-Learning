import java.util.Random;

public class Perceptron {
    private double[] weights;
    private int n;
    private final double alpha;
    private static final double biasValue = 1d;
    private static final double treshold = 0.5d;

    Perceptron(int n, double alpha) {
        Random random = new Random();
        this.weights = random.doubles((n + 1), -1d, 1d).toArray();
        this.n = n;
        this.alpha = alpha;
    }

    Perceptron(int n) {
        this(n, 0.01f);
    }

    static private double sigmoid(double x) {
        return 1 / (1 + (Math.exp(-x)));
    }

    static private boolean activate(double sum) {
        return sigmoid(sum) >= treshold;
    }

    public int feedForward(Double[] vector) {
        double sum = 0;
        for (int i = 0; i < vector.length; i++)
            sum += vector[i] * weights[i];
        sum += biasValue * weights[n];

        return activate(sum) ? 1 : 0;
    }

    public void train(Double[] vector, int targetOutput) {
        int predictedOutput = feedForward(vector);

        if (predictedOutput != targetOutput) {
            for (int i = 0; i < vector.length; i++)
                weights[i] = weights[i] + alpha * (targetOutput - predictedOutput) * vector[i];
        }
    }
}
