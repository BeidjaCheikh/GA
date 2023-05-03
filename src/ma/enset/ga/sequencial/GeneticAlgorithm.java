package ma.enset.ga.sequencial;

public interface GeneticAlgorithm {
    double fitness();
    GeneticAlgorithm reproduce(GeneticAlgorithm obj);
    GeneticAlgorithm mutate(double mutationRate);
}
