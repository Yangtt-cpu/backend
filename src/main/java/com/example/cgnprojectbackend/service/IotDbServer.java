package com.example.cgnprojectbackend.service;

import com.example.cgnprojectbackend.entity.EconomicData;
import com.example.cgnprojectbackend.entity.PredictData;
import com.example.cgnprojectbackend.entity.SymptomData;
import org.apache.iotdb.rpc.IoTDBConnectionException;
import org.apache.iotdb.rpc.StatementExecutionException;
import org.springframework.context.annotation.Configuration;

import org.springframework.stereotype.Service;

import java.util.List;


public interface IotDbServer{
    public List<PredictData> queryPredictData(List<String> measurements) throws IoTDBConnectionException, StatementExecutionException;
    public List<PredictData> queryPredictData2(List<String> measurements) throws IoTDBConnectionException, StatementExecutionException;


    public List<SymptomData> querySymptomData(List<String> measurements) throws IoTDBConnectionException, StatementExecutionException;
    public List<SymptomData> querySymptomData2(List<String> measurements) throws IoTDBConnectionException, StatementExecutionException;


    public List<EconomicData> queryEconomicData(List<String> measurements) throws IoTDBConnectionException, StatementExecutionException;
    public List<EconomicData> queryEconomicData2(List<String> measurements) throws IoTDBConnectionException, StatementExecutionException;


    public List<EconomicData> queryEconomicDateByTimeLine(List<String> measurements) throws IoTDBConnectionException, StatementExecutionException;
    public List<EconomicData> queryEconomicDateByTimeLine2(List<String> measurements) throws IoTDBConnectionException, StatementExecutionException;


    public List<PredictData> queryPredictDataByTimeLine(List<String> measurements) throws IoTDBConnectionException, StatementExecutionException;
    public List<PredictData> queryPredictDataByTimeLine2(List<String> measurements) throws IoTDBConnectionException, StatementExecutionException;

    public List<SymptomData> querySymptomDataByLine(List<String> measurements) throws IoTDBConnectionException, StatementExecutionException;
    public List<SymptomData> querySymptomDataByLine2(List<String> measurements) throws IoTDBConnectionException, StatementExecutionException;

    public List<SymptomData> querySymptomDataByInterval(String measurement,String start_time, String end_time) throws IoTDBConnectionException, StatementExecutionException;

    public List<SymptomData> querySymptomDataByInterval2(String measurement,String start_time, String end_time) throws IoTDBConnectionException, StatementExecutionException;

}
