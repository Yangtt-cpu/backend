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



    private final static List<String> U1YinfanBx_FFTAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 1023; i++){
            U1YinfanBx_FFTAMP.add("1YBQXFFT" + i);
        }
    }
    //U4Primaryfan 频谱
    private final static List<String> U4PrimaryfanAQx_FFTAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 1023; i++){
            U4PrimaryfanAQx_FFTAMP.add("4YCAQXFFT" + i);
        }
    }
    private final static List<String> U4PrimaryfanAQy_FFTAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 1023; i++){
            U4PrimaryfanAQy_FFTAMP.add("4YCAQYFFT" + i);
        }
    }
    private final static List<String> U4PrimaryfanAFx_FFTAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 1023; i++){
            U4PrimaryfanAFx_FFTAMP.add("4YCAFXFFT" + i);
        }
    }
    private final static List<String> U4PrimaryfanAFy_FFTAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 1023; i++){
            U4PrimaryfanAFy_FFTAMP.add("4YCAFYFFT" + i);
        }
    }
    private final static List<String> U4PrimaryfanBQx_FFTAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 1023; i++){
            U4PrimaryfanBQx_FFTAMP.add("4YCBQXFFT" + i);
        }
    }
    private final static List<String> U4PrimaryfanBQy_FFTAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 1023; i++){
            U4PrimaryfanBQy_FFTAMP.add("4YCBQYFFT" + i);
        }
    }
    private final static List<String> U4PrimaryfanBFx_FFTAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 1023; i++){
            U4PrimaryfanBFx_FFTAMP.add("4YCBFXFFT" + i);
        }
    }
    private final static List<String> U4PrimaryfanBFy_FFTAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 1023; i++){
            U4PrimaryfanBFy_FFTAMP.add("4YCBFYFFT" + i);
        }
    }
    //U4Sonfan
    private final static List<String> U4SonfanAQx_FFTAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 1023; i++){
            U4SonfanAQx_FFTAMP.add("4SAQXFFT" + i);
        }
    }
    private final static List<String> U4SonfanAQy_FFTAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 1023; i++){
            U4SonfanAQy_FFTAMP.add("4SAQYFFT" + i);
        }
    }
    private final static List<String> U4SonfanAFx_FFTAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 1023; i++){
            U4SonfanAFx_FFTAMP.add("4SAFXFFT" + i);
        }
    }
    private final static List<String> U4SonfanAFy_FFTAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 1023; i++){
            U4SonfanAFy_FFTAMP.add("4SAFYFFT" + i);
        }
    }
    private final static List<String> U4SonfanBQx_FFTAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 1023; i++){
            U4SonfanBQx_FFTAMP.add("4SBQXFFT" + i);
        }
    }
    private final static List<String> U4SonfanBQy_FFTAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 1023; i++){
            U4SonfanBQy_FFTAMP.add("4SBQYFFT" + i);
        }
    }
    private final static List<String> U4SonfanBFx_FFTAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 1023; i++){
            U4SonfanBFx_FFTAMP.add("4SBFXFFT" + i);
        }
    }
    private final static List<String> U4SonfanBFy_FFTAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 1023; i++){
            U4SonfanBFy_FFTAMP.add("4SBFYFFT" + i);
        }
    }
    //U4Yinfan
    private final static List<String> U4YinfanAQx_FFTAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 1023; i++){
            U4YinfanAQx_FFTAMP.add("4YAQXFFT" + i);
        }
    }
    private final static List<String> U4YinfanAQy_FFTAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 1023; i++){
            U4YinfanAQy_FFTAMP.add("4YAQYFFT" + i);
        }
    }
    private final static List<String> U4YinfanAFx_FFTAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 1023; i++){
            U4YinfanAFx_FFTAMP.add("4YAFXFFT" + i);
        }
    }
    private final static List<String> U4YinfanAFy_FFTAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 1023; i++){
            U4YinfanAFy_FFTAMP.add("4YAFYFFT" + i);
        }
    }
    private final static List<String> U4YinfanBQx_FFTAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 1023; i++){
            U4YinfanBQx_FFTAMP.add("4YBQXFFT" + i);
        }
    }
    private final static List<String> U4YinfanBQy_FFTAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 1023; i++){
            U4YinfanBQy_FFTAMP.add("4YBQYFFT" + i);
        }
    }
    private final static List<String> U4YinfanBFx_FFTAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 1023; i++){
            U4YinfanBFx_FFTAMP.add("4YBFXFFT" + i);
        }
    }
    private final static List<String> U4YinfanBFy_FFTAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 1023; i++){
            U4YinfanBFy_FFTAMP.add("4YBFYFFT" + i);
        }
    }

//包络谱

    private final static List<String> U1YinfanBx_BLPAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 255; i++) {
            U1YinfanBx_BLPAMP.add("1YBQXBLP" + i);
        }
    }
    //U4Primaryfan包络谱
    private final static List<String> U4PrimaryfanAQx_BLPAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 255; i++) {
            U4PrimaryfanAQx_BLPAMP.add("4YCAQXBLP" + i);
        }
    }
    private final static List<String> U4PrimaryfanAQy_BLPAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 255; i++) {
            U4PrimaryfanAQy_BLPAMP.add("4YCAQYBLP" + i);
        }
    }
    private final static List<String> U4PrimaryfanAFx_BLPAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 255; i++) {
            U4PrimaryfanAFx_BLPAMP.add("4YCAFXBLP" + i);
        }
    }
    private final static List<String> U4PrimaryfanAFy_BLPAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 255; i++) {
            U4PrimaryfanAFy_BLPAMP.add("4YCAFYBLP" + i);
        }
    }
    private final static List<String> U4PrimaryfanBQx_BLPAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 255; i++) {
            U4PrimaryfanBQx_BLPAMP.add("4YCBQXBLP" + i);
        }
    }
    private final static List<String> U4PrimaryfanBQy_BLPAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 255; i++) {
            U4PrimaryfanBQy_BLPAMP.add("4YCBQYBLP" + i);
        }
    }
    private final static List<String> U4PrimaryfanBFx_BLPAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 255; i++) {
            U4PrimaryfanBFx_BLPAMP.add("4YCBFXBLP" + i);
        }
    }
    private final static List<String> U4PrimaryfanBFy_BLPAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 255; i++) {
            U4PrimaryfanBFy_BLPAMP.add("4YCBFYBLP" + i);
        }
    }
    //U4Sonfan包络谱
    private final static List<String> U4SonfanAQx_BLPAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 255; i++) {
            U4SonfanAQx_BLPAMP.add("4SAQXBLP" + i);
        }
    }
    private final static List<String> U4SonfanAQy_BLPAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 255; i++) {
            U4SonfanAQy_BLPAMP.add("4SAQYBLP" + i);
        }
    }
    private final static List<String> U4SonfanAFx_BLPAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 255; i++) {
            U4SonfanAFx_BLPAMP.add("4SAFXBLP" + i);
        }
    }
    private final static List<String> U4SonfanAFy_BLPAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 255; i++) {
            U4SonfanAFy_BLPAMP.add("4SAFYBLP" + i);
        }
    }
    private final static List<String> U4SonfanBQx_BLPAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 255; i++) {
            U4SonfanBQx_BLPAMP.add("4SBQXBLP" + i);
        }
    }
    private final static List<String> U4SonfanBQy_BLPAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 255; i++) {
            U4SonfanBQy_BLPAMP.add("4SBQYBLP" + i);
        }
    }
    private final static List<String> U4SonfanBFx_BLPAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 255; i++) {
            U4SonfanBFx_BLPAMP.add("4SBFXBLP" + i);
        }
    }
    private final static List<String> U4SonfanBFy_BLPAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 255; i++) {
            U4SonfanBFy_BLPAMP.add("4SBFYBLP" + i);
        }
    }
    //U4Yinfan包络谱
    private final static List<String> U4YinfanAQx_BLPAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 255; i++) {
            U4YinfanAQx_BLPAMP.add("4YAQXBLP" + i);
        }
    }
    private final static List<String> U4YinfanAQy_BLPAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 255; i++) {
            U4YinfanAQy_BLPAMP.add("4YAQYBLP" + i);
        }
    }
    private final static List<String> U4YinfanAFx_BLPAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 255; i++) {
            U4YinfanAFx_BLPAMP.add("4YAFXBLP" + i);
        }
    }
    private final static List<String> U4YinfanAFy_BLPAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 255; i++) {
            U4YinfanAFy_BLPAMP.add("4YAFYBLP" + i);
        }
    }
    private final static List<String> U4YinfanBQx_BLPAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 255; i++) {
            U4YinfanBQx_BLPAMP.add("4YBQXBLP" + i);
        }
    }
    private final static List<String> U4YinfanBQy_BLPAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 255; i++) {
            U4YinfanBQy_BLPAMP.add("4YBQYBLP" + i);
        }
    }
    private final static List<String> U4YinfanBFx_BLPAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 255; i++) {
            U4YinfanBFx_BLPAMP.add("4YBFXBLP" + i);
        }
    }
    private final static List<String> U4YinfanBFy_BLPAMP = new ArrayList<>();

    static {
        for (int i = 0; i <= 255; i++) {
            U4YinfanBFy_BLPAMP.add("4YBFYBLP" + i);
        }
    }

    @Resource
    private IotDbServer iotDbServer;

    //U1YinfanB频谱
    @PostMapping("/queryU1YFBxfftamp")
    public RestBean<List<PredictData>> queryU1YFBFFT() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataFFT(U1YinfanBx_FFTAMP));
    }
    //U4Primaryfan频谱
    @PostMapping("/queryU4YCAQxfftamp")
    public RestBean<List<PredictData>> queryU4YCAQxFFT() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataFFT(U4PrimaryfanAQx_FFTAMP));
    }
    @PostMapping("/queryU4YCAQyfftamp")
    public RestBean<List<PredictData>> queryU4YCAQyFFT() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataFFT(U4PrimaryfanAQy_FFTAMP));
    }
    @PostMapping("/queryU4YCAFxfftamp")
    public RestBean<List<PredictData>> queryU4YCAFxFFT() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataFFT(U4PrimaryfanAFx_FFTAMP));
    }
    @PostMapping("/queryU4YCAFyfftamp")
    public RestBean<List<PredictData>> queryU4YCAFyFFT() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataFFT(U4PrimaryfanAFy_FFTAMP));
    }
    @PostMapping("/queryU4YCBQxfftamp")
    public RestBean<List<PredictData>> queryU4YCBQxFFT() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataFFT(U4PrimaryfanBQx_FFTAMP));
    }
    @PostMapping("/queryU4YCBQyfftamp")
    public RestBean<List<PredictData>> queryU4YCBQyFFT() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataFFT(U4PrimaryfanBQy_FFTAMP));
    }
    @PostMapping("/queryU4YCBFxfftamp")
    public RestBean<List<PredictData>> queryU4YCBFxFFT() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataFFT(U4PrimaryfanBFx_FFTAMP));
    }
    @PostMapping("/queryU4YCBFyfftamp")
    public RestBean<List<PredictData>> queryU4YCBFyFFT() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataFFT(U4PrimaryfanBFy_FFTAMP));
    }
    //U4Sonfan频谱
    @PostMapping("/queryU4SFAQxfftamp")
    public RestBean<List<PredictData>> queryU4SFAQxFFT() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataFFT(U4SonfanAQx_FFTAMP));
    }
    @PostMapping("/queryU4SFAQyfftamp")
    public RestBean<List<PredictData>> queryU4SFAQyFFT() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataFFT(U4SonfanAQy_FFTAMP));
    }
    @PostMapping("/queryU4SFAFxfftamp")
    public RestBean<List<PredictData>> queryU4SFAFxFFT() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataFFT(U4SonfanAFx_FFTAMP));
    }
    @PostMapping("/queryU4SFAFyfftamp")
    public RestBean<List<PredictData>> queryU4SFAFyFFT() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataFFT(U4SonfanAFy_FFTAMP));
    }
    @PostMapping("/queryU4SFBQxfftamp")
    public RestBean<List<PredictData>> queryU4SFBQxFFT() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataFFT(U4SonfanBQx_FFTAMP));
    }
    @PostMapping("/queryU4SFBQyfftamp")
    public RestBean<List<PredictData>> queryU4SFBQyFFT() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataFFT(U4SonfanBQy_FFTAMP));
    }
    @PostMapping("/queryU4SFBFxfftamp")
    public RestBean<List<PredictData>> queryU4SFBFxFFT() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataFFT(U4SonfanBFx_FFTAMP));
    }
    @PostMapping("/queryU4SFBFyfftamp")
    public RestBean<List<PredictData>> queryU4SFBFyFFT() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataFFT(U4SonfanBFy_FFTAMP));
    }
    //U4Yinfan频谱
    @PostMapping("/queryU4YFAQxfftamp")
    public RestBean<List<PredictData>> queryU4YFAQxFFT() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataFFT(U4YinfanAQx_FFTAMP));
    }
    @PostMapping("/queryU4YFAQyfftamp")
    public RestBean<List<PredictData>> queryU4YFAQyFFT() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataFFT(U4YinfanAQy_FFTAMP));
    }
    @PostMapping("/queryU4YFAFxfftamp")
    public RestBean<List<PredictData>> queryU4YFAFxFFT() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataFFT(U4YinfanAFx_FFTAMP));
    }
    @PostMapping("/queryU4YFAFyfftamp")
    public RestBean<List<PredictData>> queryU4YFAFyFFT() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataFFT(U4YinfanAFy_FFTAMP));
    }
    @PostMapping("/queryU4YFBQxfftamp")
    public RestBean<List<PredictData>> queryU4YFBQxFFT() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataFFT(U4YinfanBQx_FFTAMP));
    }
    @PostMapping("/queryU4YFBQyfftamp")
    public RestBean<List<PredictData>> queryU4YFBQyFFT() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataFFT(U4YinfanBQy_FFTAMP));
    }
    @PostMapping("/queryU4YFBFxfftamp")
    public RestBean<List<PredictData>> queryU4YFBFxFFT() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataFFT(U4YinfanBFx_FFTAMP));
    }
    @PostMapping("/queryU4YFBFyfftamp")
    public RestBean<List<PredictData>> queryU4YFBFyFFT() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataFFT(U4YinfanBFy_FFTAMP));
    }



    //U1YinfanB包络谱
    @PostMapping("/queryU1YFBxblpamp")
    public RestBean<List<PredictData>> queryU1YFBBLP() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataBLP(U1YinfanBx_BLPAMP));
    }
    //U4Primaryfan包络谱
    @PostMapping("/queryU4YCAQxblpamp")
    public RestBean<List<PredictData>> queryU4YCAQxBLP() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataBLP(U4PrimaryfanAQx_BLPAMP));
    }
    @PostMapping("/queryU4YCAQyblpamp")
    public RestBean<List<PredictData>> queryU4YCAQyBLP() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataBLP(U4PrimaryfanAQy_BLPAMP));
    }
    @PostMapping("/queryU4YCAFxblpamp")
    public RestBean<List<PredictData>> queryU4YCAFxBLP() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataBLP(U4PrimaryfanAFx_BLPAMP));
    }
    @PostMapping("/queryU4YCBAFyblpamp")
    public RestBean<List<PredictData>> queryU4YCAFyBLP() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataBLP(U4PrimaryfanAFy_BLPAMP));
    }
    @PostMapping("/queryU4YCBQxblpamp")
    public RestBean<List<PredictData>> queryU4YCBQxBLP() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataBLP(U4PrimaryfanBQx_BLPAMP));
    }
    @PostMapping("/queryU4YCBQyblpamp")
    public RestBean<List<PredictData>> queryU4YCBQyBLP() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataBLP(U4PrimaryfanBQy_BLPAMP));
    }
    @PostMapping("/queryU4YCBFxblpamp")
    public RestBean<List<PredictData>> queryU4YCBFxBLP() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataBLP(U4PrimaryfanBFx_BLPAMP));
    }
    @PostMapping("/queryU4YCBFyblpamp")
    public RestBean<List<PredictData>> queryU4YCBFyBLP() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataBLP(U4PrimaryfanBFy_BLPAMP));
    }
    //U4Sonfan包络谱
    @PostMapping("/queryU4SFAQxblpamp")
    public RestBean<List<PredictData>> queryU4SFAQxBLP() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataBLP(U4SonfanAQx_BLPAMP));
    }
    @PostMapping("/queryU4SFAQyblpamp")
    public RestBean<List<PredictData>> queryU4SFAQyBLP() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataBLP(U4YinfanAQy_BLPAMP));
    }
    @PostMapping("/queryU4SFAFxblpamp")
    public RestBean<List<PredictData>> queryU4SFAFxBLP() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataBLP(U4SonfanAFx_BLPAMP));
    }
    @PostMapping("/queryU4SFBAFyblpamp")
    public RestBean<List<PredictData>> queryU4SFAFyBLP() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataBLP(U4SonfanAFy_BLPAMP));
    }
    @PostMapping("/queryU4SFBQxblpamp")
    public RestBean<List<PredictData>> queryU4SFBQxBLP() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataBLP(U4SonfanBQx_BLPAMP));
    }
    @PostMapping("/queryU4SFBQyblpamp")
    public RestBean<List<PredictData>> queryU4SFBQyBLP() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataBLP(U4SonfanBQy_BLPAMP));
    }
    @PostMapping("/queryU4SFBFxblpamp")
    public RestBean<List<PredictData>> queryU4SFBFxBLP() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataBLP(U4SonfanBFx_BLPAMP));
    }
    @PostMapping("/queryU4SFBFyblpamp")
    public RestBean<List<PredictData>> queryU4SFBFyBLP() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataBLP(U4SonfanBFy_BLPAMP));
    }
    //U4Yinfan包络谱
    @PostMapping("/queryU4YFBAQxblpamp")
    public RestBean<List<PredictData>> queryU4YFAQxBLP() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataBLP(U4YinfanAQx_BLPAMP));
    }
    @PostMapping("/queryU4YFBAQyblpamp")
    public RestBean<List<PredictData>> queryU4YFAQyBLP() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataBLP(U4YinfanAQy_BLPAMP));
    }
    @PostMapping("/queryU4YFBAFxblpamp")
    public RestBean<List<PredictData>> queryU4YFAFxBLP() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataBLP(U4YinfanAFx_BLPAMP));
    }
    @PostMapping("/queryU4YFBAFyblpamp")
    public RestBean<List<PredictData>> queryU4YFAFyBLP() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataBLP(U4YinfanAFy_BLPAMP));
    }
    @PostMapping("/queryU4YFBBQxblpamp")
    public RestBean<List<PredictData>> queryU4YFBQxBLP() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataBLP(U4YinfanBQx_BLPAMP));
    }
    @PostMapping("/queryU4YFBBQyblpamp")
    public RestBean<List<PredictData>> queryU4YFBQyBLP() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataBLP(U4YinfanBQy_BLPAMP));
    }
    @PostMapping("/queryU4YFBBFxblpamp")
    public RestBean<List<PredictData>> queryU4YFBFxBLP() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataBLP(U4YinfanBFx_BLPAMP));
    }
    @PostMapping("/queryU4YFBBFyblpamp")
    public RestBean<List<PredictData>> queryU4YFBFyBLP() throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictDataBLP(U4YinfanBFy_BLPAMP));
    }



    @PostMapping("/queryJiankangdu")
    public RestBean<List<PredictData>> queryJKDData(@RequestParam("measurements")  List<String> measurements) throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryJKDData(measurements));
    }
    @PostMapping("/queryJiankangdu2")
    public RestBean<List<PredictData>> queryJKDData2(@RequestParam("measurements")  List<String> measurements) throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryJKDData2(measurements));
    }


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
    @PostMapping("/queryPredictPass2")
    public RestBean<List<PredictData>> queryPredictData2(@RequestParam("measurements")  List<String> measurements) throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer.queryPredictData2(measurements));
    }
     //访问全部有效值
    @PostMapping("/queryPredictPass")
    public RestBean<List<PredictData>> queryPredictData(@RequestParam("measurements")  List<String> measurements) throws IoTDBConnectionException, StatementExecutionException {
        return RestBean.success(iotDbServer. queryPredictData(measurements));
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

