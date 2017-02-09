package com.ANNBets.ann;

import com.ANNBets.dto.Prepared1X2Data;
import com.ANNBets.entities.Team;
import com.googlecode.fannj.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by siarhei_beliabniou on 27.1.17.
 */
public class ANNExecutor {

    public void doANN() {
        List<Layer> layerList = new ArrayList<>();
        layerList.add(Layer.create(3, ActivationFunction.FANN_SIGMOID_SYMMETRIC, 0.1f));
        layerList.add(Layer.create(18, ActivationFunction.FANN_SIGMOID_SYMMETRIC, 0.1f));
        layerList.add(Layer.create(3, ActivationFunction.FANN_SIGMOID_SYMMETRIC, 0.1f));

        Fann fann = new Fann(layerList);

        Trainer trainer = new Trainer(fann);

        trainer.setTrainingAlgorithm(TrainingAlgorithm.FANN_TRAIN_RPROP);
        trainer.train("/home/siarhei_beliabniou/training.data", 100000, 100, 0.0001f);

        fann.save("/home/siarhei_beliabniou/trained.net");
    }

    public void getPrediction(Team homeTeam, Team awayTeam){
        Fann fann = new Fann("/home/siarhei_beliabniou/trained.net");
        Prepared1X2Data prepare = ANNDataSupplier.prepare(homeTeam, awayTeam);
        float[] test = {prepare.getLast10HTHM(), prepare.getLast10ATAM(), prepare.getLast10TvTM()};

        float[] run = fann.run(test);
        int i=0;


    }

}
