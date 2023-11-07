package com.example.myapplication.projectlab.Lab10.Exe1;


public class TraineeRepository {
    public static TraineeService getTraineeService() {
        return APIClient.getClient().create(TraineeService.class);
    }
}
