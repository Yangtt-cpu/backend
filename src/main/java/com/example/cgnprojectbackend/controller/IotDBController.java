package com.example.cgnprojectbackend.controller;


import com.example.cgnprojectbackend.entity.*;
import com.example.cgnprojectbackend.service.IotDbServer;
import lombok.extern.log4j.Log4j2;
import org.apache.iotdb.rpc.IoTDBConnectionException;
import org.apache.iotdb.rpc.StatementExecutionException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@RestController
@RequestMapping(value = "/api/device",method = {RequestMethod.GET,RequestMethod.POST})
@Validated


public class IotDBController {

    private final static List<String> ALL_BLPAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 255; i++) {
            ALL_BLPAMP.add("blpamp" + i);
        }
    }

    private final static List<String> ALL_FFTAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 1023; i++){
            ALL_FFTAMP.add("fftamp" + i);
        }
    }

    @Resource
    private IotDbServer iotDbServer;


    @PostMapping("/queryblpamp")
    public RestBean<List<PredictData>> queryPredictDataByTimeLine2() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataByTimeLine2(ALL_BLPAMP));
    }
    @PostMapping("/queryfftamp")
    public RestBean<List<PredictData>> queryPredictDataFFT() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataFFT(ALL_FFTAMP));
    }
    @PostMapping("/queryAlert")
    public RestBean<List<Alert>> queryAlert(@RequestParam("yujingzhis") List<String> yujingzhis) throws IoTDBConnectionException,StatementExecutionException {
        return RestBean.success(iotDbServer. queryAlert(yujingzhis));
    }

    @PostMapping("/queryPredictPass")
    public RestBean<List<PredictData>> queryPredictData(@RequestParam("measurements")  List<String> measurements) throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer. queryPredictData(measurements));
    }
    @PostMapping("/queryPredictPass2")
    public RestBean<List<PredictData>> queryPredictData2(@RequestParam("measurements")  List<String> measurements) throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictData2(measurements));
    }

    @PostMapping("/queryPredictPassByline")
    public RestBean<List<PredictData>> queryPredictDataByTimeLine(@RequestParam("measurements")  List<String> measurements) throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataByTimeLine(measurements));
    }
    @PostMapping("/queryPredictPassByline2")
    public RestBean<List<PredictData>> queryPredictDataByTimeLine2(@RequestParam("measurements")  List<String> measurements) throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataByTimeLine2(measurements));
    }

    @PostMapping("/querySymptom")
    public RestBean<List<SymptomData>> querySymptomData(@RequestParam("measurements")  List<String> measurements) throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.querySymptomData(measurements));
    }

    @PostMapping("/querySymptom2")
    public RestBean<List<SymptomData>> querySymptomData2(@RequestParam("measurements")  List<String> measurements) throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.querySymptomData2(measurements));
    }

    @PostMapping("/querySymptomByLine")
    public RestBean<List<SymptomData>> querySymptomDataByLine(@RequestParam("measurements")  List<String> measurements) throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.querySymptomDataByLine(measurements));
    }

    @PostMapping("/querySymptomByLine2")
    public RestBean<List<SymptomData>> querySymptomDataByLine2(@RequestParam("measurements")  List<String> measurements) throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.querySymptomDataByLine2(measurements));
    }

    @PostMapping("/querySymptomByInterval")
    public RestBean<List<SymptomData>> querySymptomDataByInterval(@RequestParam("measurement")  String measurement, @RequestParam("start_time") String start_time, @RequestParam("end_time") String end_time) throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.querySymptomDataByInterval(measurement,start_time,end_time));
    }

    @PostMapping("/querySymptomByInterval2")
    public RestBean<List<SymptomData>> querySymptomDataByInterval2(@RequestParam("measurement")  String measurement, @RequestParam("start_time") String start_time, @RequestParam("end_time") String end_time) throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.querySymptomDataByInterval2(measurement,start_time,end_time));
    }
    @PostMapping("/queryEconomic")
    public RestBean<List<EconomicData>> queryEconomicData(@RequestParam("measurements") List<String> measurements) throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryEconomicData(measurements));
    }
    @PostMapping("/queryEconomic2")
    public RestBean<List<EconomicData>> queryEconomicData2(@RequestParam("measurements") List<String> measurements) throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryEconomicData2(measurements));
    }
    @PostMapping("/queryEconomicByLine")
    public RestBean<List<EconomicData>> queryEconomicDateByTimeLine(@RequestParam("measurements") List<String> measurements) throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryEconomicDateByTimeLine(measurements));
    }

    @PostMapping("/queryEconomicByLine2")
    public RestBean<List<EconomicData>> queryEconomicDateByTimeLine2(@RequestParam("measurements") List<String> measurements) throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryEconomicDateByTimeLine2(measurements));
    }

}

