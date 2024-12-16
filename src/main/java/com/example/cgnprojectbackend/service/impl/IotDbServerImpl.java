package com.example.cgnprojectbackend.service.impl;

import com.example.cgnprojectbackend.config.IotDBSessionConfig;
import com.example.cgnprojectbackend.entity.EconomicData;
import com.example.cgnprojectbackend.entity.PredictData;
import com.example.cgnprojectbackend.entity.SymptomData;
import com.example.cgnprojectbackend.entity.Alert;
import com.example.cgnprojectbackend.service.IotDbServer;
import lombok.extern.log4j.Log4j2;
import org.apache.iotdb.rpc.IoTDBConnectionException;
import org.apache.iotdb.rpc.StatementExecutionException;
import org.apache.iotdb.session.SessionDataSet;
import org.apache.iotdb.tsfile.read.common.Field;
import org.apache.iotdb.tsfile.read.common.RowRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class IotDbServerImpl implements IotDbServer {

    @Resource
    private IotDBSessionConfig iotDBSessionConfig;


    @Value("${spring.iotdb.predict_device:root.ciia.fcg.unit1.preresult}")
    private String predict_device;

//    @Value("${spring.iotdb.predict_device2:root.ciia.fcg.unit2.preresult}")
    @Value("${spring.iotdb.predict_device2:root.vibdata.card28.channel2}")
    private String predict_device2;

    public List<Alert> queryAlert(List<String>yujingzhis)
        throws IoTDBConnectionException,StatementExecutionException {
        List<Alert> result = new ArrayList<>();
         if (yujingzhis !=null){
             for (String yujingzhi:yujingzhis)
             {
                 String sql = "select last " + yujingzhi + " from " + predict_device2;
                 SessionDataSet sessionDataSet = iotDBSessionConfig.query(sql);
                 int fetSize = sessionDataSet.getFetchSize();
                 if (fetSize>0){
                     while ( (sessionDataSet.hasNext())){
                         Alert alert = new Alert();
                         RowRecord next = sessionDataSet.next();
                         List<Field> fields = next .getFields();
                         alert.setYujingzhi(yujingzhi);
                         alert.setValue(fields.get(1).toString());
                         result.add(alert);
                     }
                 }
             }
         }
         return result;
    }

    public  List<PredictData> queryPredictData(List<String> measurements)
        throws IoTDBConnectionException, StatementExecutionException {

        List<PredictData> result = new ArrayList<>();
        if(measurements != null){
            for (String measurement:measurements
            ) {
                String sql = "select last " + measurement +" from "+ predict_device;
                SessionDataSet sessionDataSet = iotDBSessionConfig
                        .query(sql);
                int fetchSize = sessionDataSet.getFetchSize();
                if(fetchSize>0){
                    while (sessionDataSet.hasNext()){
                        PredictData predictData = new PredictData();
                        RowRecord next = sessionDataSet.next();
                        List<Field> fields = next.getFields();
                        predictData.setMeasurement(measurement);
                        predictData.setTime(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(next.getTimestamp()));
                        predictData.setValue(fields.get(1).toString());
                        result.add(predictData);
                    }
                }
            }
        }

        return result;
    }

    @Override
    public  List<PredictData> queryPredictData2(List<String> measurements)
            throws IoTDBConnectionException, StatementExecutionException {

        List<PredictData> result = new ArrayList<>();
        if(measurements != null){
            for (String measurement:measurements
            ) {
                String sql = "select " + measurement +" from "+ predict_device2 + " order by time desc limit 1000";
                //String sql = "select" + measurement +" from "+ predict_device2;
                SessionDataSet sessionDataSet = iotDBSessionConfig
                        .query(sql);
                System.out.println("sql"+sql);
                int fetchSize = sessionDataSet.getFetchSize();
                System.out.println("fetchSize"+fetchSize);
                if(fetchSize>0){
                    while (sessionDataSet.hasNext()){
                        PredictData predictData = new PredictData();
                        RowRecord next = sessionDataSet.next();
                        List<Field> fields = next.getFields();
                        predictData.setMeasurement(measurement);
                        predictData.setTime(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(next.getTimestamp()));
                        predictData.setValue(fields.get(0).toString());
                        result.add(predictData);
                    }
                }
            }
        }
        List<PredictData> result2 = new ArrayList<>();
        for (int i = result.size() - 1; i >= 0; i--) {
            result2.add(result.get(i));
        }
        return result2;
    }

    @Override
    public  List<PredictData> queryPredictDataByTimeLine(List<String> measurements) throws IoTDBConnectionException, StatementExecutionException {
        List<PredictData> result = new ArrayList<>();
        if(measurements != null){
            for (String measurement:measurements
            ) {
                //查询当前时间的前1个小时的数据
                String queryTime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()-1000*60*60);
                String sql = "select " + measurement +" from "+ predict_device +" where time > "+ queryTime;
                SessionDataSet sessionDataSet = iotDBSessionConfig
                        .query(sql);
                int fetchSize = sessionDataSet.getFetchSize();
                if(fetchSize>0){
                    while (sessionDataSet.hasNext()){
                        PredictData predictData = new PredictData();
                        RowRecord next = sessionDataSet.next();
                        List<Field> fields = next.getFields();
                        predictData.setMeasurement(measurement);
                        predictData.setTime(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(next.getTimestamp()));
                        predictData.setValue(fields.get(0).toString());
                        result.add(predictData);
                    }
                }
            }
        }

        return result;
    }

    @Override
    public  List<PredictData> queryPredictDataByTimeLine2(List<String> measurements) throws IoTDBConnectionException, StatementExecutionException {
        List<PredictData> result = new ArrayList<>();
        if(measurements != null){
            for (String measurement:measurements
            ) {
                //查询当前时间的前1个小时的数据
                String queryTime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()-1000*60*60);
                String sql = "select " + measurement +" from "+ predict_device2+ " order by time desc limit 1 ";
                SessionDataSet sessionDataSet = iotDBSessionConfig
                        .query(sql);
                int fetchSize = sessionDataSet.getFetchSize();
                if(fetchSize>0){
                    while (sessionDataSet.hasNext()){
                        PredictData predictData = new PredictData();
                        RowRecord next = sessionDataSet.next();
                        List<Field> fields = next.getFields();
                        predictData.setMeasurement(measurement);
                        predictData.setTime(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(next.getTimestamp()));
                        predictData.setValue(fields.get(0).toString());
                        result.add(predictData);
                    }
                }
            }
        }

        return result;
    }

    @Override
    public  List<PredictData> queryPredictDataFFT(List<String> measurements) throws IoTDBConnectionException, StatementExecutionException {
        List<PredictData> result = new ArrayList<>();
        if(measurements != null){
            for (String measurement:measurements
            ) {
                //查询当前时间的前1个小时的数据
                String queryTime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()-1000*60*60);
                String sql = "select " + measurement +" from "+ predict_device2+ " order by time desc limit 1 ";
                SessionDataSet sessionDataSet = iotDBSessionConfig
                        .query(sql);
                int fetchSize = sessionDataSet.getFetchSize();
                if(fetchSize>0){
                    while (sessionDataSet.hasNext()){
                        PredictData predictData = new PredictData();
                        RowRecord next = sessionDataSet.next();
                        List<Field> fields = next.getFields();
                        predictData.setMeasurement(measurement);
                        predictData.setTime(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(next.getTimestamp()));
                        predictData.setValue(fields.get(0).toString());
                        result.add(predictData);
                    }
                }
            }
        }

        return result;
    }

    @Value("${Spring.iotdb.symptom_device:root.ciia.fcg.unit1.symptom}")
    private  String symptom_device;

    @Value("${Spring.iotdb.symptom_device:root.ciia.fcg.unit2.symptom}")
    private  String symptom_device2;

    @Override
    public List<SymptomData> querySymptomData(List<String> measurements) throws IoTDBConnectionException, StatementExecutionException {
        List<SymptomData> result = new ArrayList<>();
        if(measurements != null){
            for (String measurement:measurements
            ) {
                String sql = "select last " + measurement +" from "+ symptom_device;
                SessionDataSet sessionDataSet = iotDBSessionConfig
                        .query(sql);
                int fetchSize = sessionDataSet.getFetchSize();
                if(fetchSize>0){
                    while (sessionDataSet.hasNext()){
                        SymptomData symptomData = new SymptomData();
                        RowRecord next = sessionDataSet.next();
                        List<Field> fields = next.getFields();
                        symptomData.setMeasurement(measurement);
                        symptomData.setTime(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(next.getTimestamp()));
                        symptomData.setValue(fields.get(1).toString());
                        result.add(symptomData);
                    }
                }
            }
        }

        return result;
    }

    @Override
    public List<SymptomData> querySymptomData2(List<String> measurements) throws IoTDBConnectionException, StatementExecutionException {
        List<SymptomData> result = new ArrayList<>();
        if(measurements != null){
            for (String measurement:measurements
            ) {
                String sql = "select last " + measurement +" from "+ symptom_device2;
                SessionDataSet sessionDataSet = iotDBSessionConfig
                        .query(sql);
                int fetchSize = sessionDataSet.getFetchSize();
                if(fetchSize>0){
                    while (sessionDataSet.hasNext()){
                        SymptomData symptomData = new SymptomData();
                        RowRecord next = sessionDataSet.next();
                        List<Field> fields = next.getFields();
                        symptomData.setMeasurement(measurement);
                        symptomData.setTime(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(next.getTimestamp()));
                        symptomData.setValue(fields.get(1).toString());
                        result.add(symptomData);
                    }
                }
            }
        }

        return result;
    }

    @Override
    public List<SymptomData> querySymptomDataByLine(List<String> measurements) throws IoTDBConnectionException, StatementExecutionException {
        List<SymptomData> result = new ArrayList<>();
        if(measurements != null){
            for (String measurement:measurements
            ) {
                //查询当前时间的前1个小时的数据
                String queryTime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()-1000*60*60);
                String sql = "select " + measurement +" from "+ symptom_device+" where time > "+ queryTime;
                SessionDataSet sessionDataSet = iotDBSessionConfig
                        .query(sql);
                int fetchSize = sessionDataSet.getFetchSize();
                if(fetchSize>0){
                    while (sessionDataSet.hasNext()){
                        SymptomData symptomData = new SymptomData();
                        RowRecord next = sessionDataSet.next();
                        List<Field> fields = next.getFields();
                        symptomData.setMeasurement(measurement);
                        symptomData.setTime(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(next.getTimestamp()));
                        symptomData.setValue(fields.get(0).toString());
                        result.add(symptomData);
                    }
                }
            }
        }

        return result;
    }

    @Override
    public List<SymptomData> querySymptomDataByLine2(List<String> measurements) throws IoTDBConnectionException, StatementExecutionException {
        List<SymptomData> result = new ArrayList<>();
        if(measurements != null){
            for (String measurement:measurements
            ) {
                //查询当前时间的前1个小时的数据
                String queryTime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()-1000*60*60);
                String sql = "select " + measurement +" from "+ symptom_device2+" where time > "+ queryTime;
                SessionDataSet sessionDataSet = iotDBSessionConfig
                        .query(sql);
                int fetchSize = sessionDataSet.getFetchSize();
                if(fetchSize>0){
                    while (sessionDataSet.hasNext()){
                        SymptomData symptomData = new SymptomData();
                        RowRecord next = sessionDataSet.next();
                        List<Field> fields = next.getFields();
                        symptomData.setMeasurement(measurement);
                        symptomData.setTime(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(next.getTimestamp()));
                        symptomData.setValue(fields.get(0).toString());
                        result.add(symptomData);
                    }
                }
            }
        }

        return result;
    }

    @Override
    public List<SymptomData> querySymptomDataByInterval(String measurement, String start_time, String end_time) throws IoTDBConnectionException, StatementExecutionException {
        List<SymptomData> result = new ArrayList<>();

        if(measurement != null){
                String sql = "select " + measurement +" from "+ symptom_device+" where time > "+ start_time + " and time < "+end_time ;
                SessionDataSet sessionDataSet = iotDBSessionConfig
                        .query(sql);
                int fetchSize = sessionDataSet.getFetchSize();
                if(fetchSize>0){
                    while (sessionDataSet.hasNext()){
                        SymptomData symptomData = new SymptomData();
                        RowRecord next = sessionDataSet.next();
                        List<Field> fields = next.getFields();
                        symptomData.setMeasurement(measurement);
                        symptomData.setTime(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(next.getTimestamp()));
                        symptomData.setValue(fields.get(0).toString());
                        result.add(symptomData);
                    }
                }
        }

        return result;
    }

    @Override
    public List<SymptomData> querySymptomDataByInterval2(String measurement, String start_time, String end_time) throws IoTDBConnectionException, StatementExecutionException {
        List<SymptomData> result = new ArrayList<>();

        if(measurement != null){
            String sql = "select " + measurement +" from "+ symptom_device2+" where time > "+ start_time + " and time < "+end_time ;
            SessionDataSet sessionDataSet = iotDBSessionConfig
                    .query(sql);
            int fetchSize = sessionDataSet.getFetchSize();
            if(fetchSize>0){
                while (sessionDataSet.hasNext()){
                    SymptomData symptomData = new SymptomData();
                    RowRecord next = sessionDataSet.next();
                    List<Field> fields = next.getFields();
                    symptomData.setMeasurement(measurement);
                    symptomData.setTime(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(next.getTimestamp()));
                    symptomData.setValue(fields.get(0).toString());
                    result.add(symptomData);
                }
            }
        }

        return result;
    }

    @Value("${Spring.iotdb.economic_device:root.ciia.fcg.unit1.economic}")
    private String economic_device;

    @Value("${Spring.iotdb.economic_device2:root.ciia.fcg.unit2.economic}")
    private String economic_device2;
    @Override
    public List<EconomicData> queryEconomicData(List<String> measurements) throws IoTDBConnectionException, StatementExecutionException {
        List<EconomicData> result = new ArrayList<>();
        if(measurements != null){
            for (String measurement:measurements
            ) {
                String sql = "select last " + measurement +" from "+ economic_device;;
                SessionDataSet sessionDataSet = iotDBSessionConfig
                        .query(sql);
                int fetchSize = sessionDataSet.getFetchSize();
                if(fetchSize>0){
                    while (sessionDataSet.hasNext()){
                        EconomicData economicData = new EconomicData();
                        RowRecord next = sessionDataSet.next();
                        List<Field> fields = next.getFields();
                        economicData.setMeasurement(measurement);
                        economicData.setTime(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(next.getTimestamp()));
                        economicData.setValue(fields.get(1).toString());
                        result.add(economicData);
                    }
                }
            }
        }

        return result;
    }

    @Override
    public List<EconomicData> queryEconomicData2(List<String> measurements) throws IoTDBConnectionException, StatementExecutionException {
        List<EconomicData> result = new ArrayList<>();
        if(measurements != null){
            for (String measurement:measurements
            ) {
                String sql = "select last " + measurement +" from "+ economic_device2;;
                SessionDataSet sessionDataSet = iotDBSessionConfig
                        .query(sql);
                int fetchSize = sessionDataSet.getFetchSize();
                if(fetchSize>0){
                    while (sessionDataSet.hasNext()){
                        EconomicData economicData = new EconomicData();
                        RowRecord next = sessionDataSet.next();
                        List<Field> fields = next.getFields();
                        economicData.setMeasurement(measurement);
                        economicData.setTime(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(next.getTimestamp()));
                        economicData.setValue(fields.get(1).toString());
                        result.add(economicData);
                    }
                }
            }
        }

        return result;
    }
    @Override
    public List<EconomicData> queryEconomicDateByTimeLine(List<String> measurements) throws IoTDBConnectionException, StatementExecutionException {

        List<EconomicData> result = new ArrayList<>();
        if(measurements != null){
            for (String measurement:measurements
            ) {
                //查询当前时间的前1个小时的数据
                String queryTime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()-1000*60*60);
                String sql = "select " + measurement +" from "+ economic_device+" where time > "+ queryTime;
                SessionDataSet sessionDataSet = iotDBSessionConfig
                        .query(sql);
                int fetchSize = sessionDataSet.getFetchSize();
                if(fetchSize>0){
                    while (sessionDataSet.hasNext()){
                        EconomicData economicData = new EconomicData();
                        RowRecord next = sessionDataSet.next();
                        List<Field> fields = next.getFields();
                        economicData.setMeasurement(measurement);
                        economicData.setTime(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(next.getTimestamp()));
                        economicData.setValue(fields.get(0).toString());
                        result.add(economicData);
                    }
                }
            }
        }

        return result;
    }

    @Override
    public List<EconomicData> queryEconomicDateByTimeLine2(List<String> measurements) throws IoTDBConnectionException, StatementExecutionException {

        List<EconomicData> result = new ArrayList<>();
        if(measurements != null){
            for (String measurement:measurements
            ) {
                //查询当前时间的前1个小时的数据
                String queryTime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()-1000*60*60);
                String sql = "select " + measurement +" from "+ economic_device2+" where time > "+ queryTime;
                SessionDataSet sessionDataSet = iotDBSessionConfig
                        .query(sql);
                int fetchSize = sessionDataSet.getFetchSize();
                if(fetchSize>0){
                    while (sessionDataSet.hasNext()){
                        EconomicData economicData = new EconomicData();
                        RowRecord next = sessionDataSet.next();
                        List<Field> fields = next.getFields();
                        economicData.setMeasurement(measurement);
                        economicData.setTime(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(next.getTimestamp()));
                        economicData.setValue(fields.get(0).toString());
                        result.add(economicData);
                    }
                }
            }
        }

        return result;
    }

}
