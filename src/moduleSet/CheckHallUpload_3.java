package moduleSet;

import idcheck.Id_3check;
import stringcheck.TimeDatecheck;
import stringcheck.regularExpressionChcek;
import stringcheck.telIdentification;

public class CheckHallUpload_3 {
	static regularExpressionChcek rec = new regularExpressionChcek();
	static String[] ServiceItems={"01","02","03","04","05","06","07","08","09","10",
			"11","12","13","14","15","16","17","18","19","20",
			"21","22","23","24","25","26","27","28","29","30",
			"31","32","33","34","35","36","37"};  //服务项目
	
	public static boolean [] array = {false, false,false,false,false,
		false,false,false,false,false};
	
	static final String userUploaddw[] = {"id","name","contact","tel","address",  //10项必填
		"serviceItems","businessHours","startTime","endTime","operation"};
	
	public static String checkRequiredKey(){  
		String results = "";

			for(int i=0; i<array.length; i++){
//				System.out.println("array： "+array[i]);
				if(array[i] == false){
						if(results.equals("")){
							results = userUploaddw[i];
						}
						else results = results +","+ userUploaddw[i];
				}
			}
			initArray();
			return results;
	}
	
	public static void initArray(){  //初始化array数组
		for(int i=0; i<array.length; i++){
			array[i] = false;
		}
	}
	
	public static String checkServeStation(String key, Object obj){
		if(key.equals("id")) return checkId(obj);
		else if (key.equals("name")) return checkName(obj);
		else if (key.equals("contact")) return checkContanct(obj);
		else if (key.equals("tel")) return checkTel(obj);
		else if (key.equals("address")) return checkAddress(obj);
		else if (key.equals("serviceItems")) return checkServiceItems(obj);
		else if (key.equals("businessHours")) return checkBusinessHours(obj);
		else if (key.equals("startTime")) return checkStartTime(obj);
		else if (key.equals("endTime")) return checkEndTime(obj);
		else if (key.equals("operation")) return checkOperation(obj);
		else if (key.equals("timeMillStr")) return "right";
		else return "NO";
	}
	
	public static boolean isServiceItems(String items) { // 判断字符串是否为服务项目组合（附录表十）
		String[] item = items.split(",");
		int m = 0;
		for (int i = 0; i < item.length; i++) {
			for (String temp : ServiceItems) {
				if (item[i].equals(temp)) {
					++m;
				}
			}
		}
		if (item.length == m) {
			return true;
		} else
			return false;
	}
	
	public static boolean iscontainSerI(String id){  //判断单个单个服务项目
		for(String temp:ServiceItems){
			if(id.equals(temp)){
				return true;
			}
		}
		return false;
	}
	
	public static String checkId(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[0] = true;
		 Id_3check check1 = new Id_3check();
		 if (id == null || (id.toString()).length() <= 0
				 || id.toString().equals("null") || id.toString().equals("NULL")){
			 return "必填项缺失";
		 }
		 boolean type = id instanceof String;
		 if (type){
			 return check1.check(id.toString());
		 }
		return "数据类型不符";
	 }
	 
	 public static String checkName(Object name){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[1] = true;
		 if (name == null || (name.toString()).length() <= 0
				 || name.toString().equals("null") || name.toString().equals("NULL")){
			 return "必填项缺失";
		 }
		 boolean type = name instanceof String;
		 if (type){
			 if ((name.toString()).length() <= 50) {
					if (rec.checkName2(name.toString())) {
						return "right";
					} else
						return "存在非法字符";
				} else
					return "长度有误";
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkContanct(Object contanct){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[2] = true;
		 if (contanct == null || (contanct.toString()).length() <= 0
				 || contanct.toString().equals("null") || contanct.toString().equals("NULL")){
			 return "必填项缺失";
		 }
		 boolean type = contanct instanceof String;
		 if (type){
			 if ((contanct.toString()).length() <= 50) {
					if (rec.checkName1(contanct.toString())) {
						return "right";
					} else
						return "存在非法字符";
				} else
					return "长度有误";
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkTel(Object tel){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[3] = true;
		 if (tel == null || (tel.toString()).length() <= 0
				 || tel.toString().equals("null") || tel.toString().equals("NULL")){
			 return "必填项缺失";
		 }
		 boolean type = tel instanceof String;
		 if (type){
			 telIdentification telTemp = new telIdentification();
			 if(tel.toString().length() >= 10 && tel.toString().length() <= 20){
				 if (telTemp.identifyTel(tel.toString()).equals("right")){
					 return "right";
				 }
				 else return telTemp.identifyTel(tel.toString());
			 }
			 else return "长度有误";
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkAddress(Object address){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[4] = true;
		 if (address == null || (address.toString()).length() <= 0
				 || address.toString().equals("null") || address.toString().equals("NULL")){
			 return "必填项缺失";
		 }
		 boolean type = address instanceof String;
		 if (type){
			 if ((address.toString()).length() <= 100) {
					if (rec.checkAddress(address.toString())) {
						return "right";
					} else
						return "存在非法字符";
				} else
					return "长度有误";
		 }
		 return "数据类型不符";
	 }
	 
	public static String checkServiceItems(Object serviceItems) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[5] = true;
		if (serviceItems == null || (serviceItems.toString()).length() <= 0
				|| serviceItems.toString().equals("null") || serviceItems.toString().equals("NULL")) {
			return "必填项缺失";
		}
		boolean type = serviceItems instanceof String;
		if (type) {
			if ((serviceItems.toString()).length() <= 150) {
				if (serviceItems.toString().contains(",")) {  //当有多个服务项目
					if (isServiceItems(serviceItems.toString())) {
						return "right";
					} else
						return "服务项目范围有误";
				} else if(iscontainSerI(serviceItems.toString())){  //单个服务项目
					return "right";
				} else
					return "格式或编码范围错误";
			} else
				return "长度有误";
		}
		return "数据类型不符";
	}
	 
	 public static String checkBusinessHours(Object businessHours){ //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[6] = true;
		 if (businessHours == null || (businessHours.toString()).length() <= 0
				 || businessHours.toString().equals("null") || businessHours.toString().equals("NULL")){
			 return "必填项缺失";
		 }
		 boolean type = businessHours instanceof String;
		 if (type){
			 if ((businessHours.toString()).length() <= 100) {
					if (rec.checkBusinessHours(businessHours.toString())) {
						return "right";
					} else
						return "存在非法字符";
				} else
					return "长度有误";
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkStartTime(Object startTime){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[7] = true;
		 TimeDatecheck time1 = new TimeDatecheck();
		 if (startTime == null || (startTime.toString()).length() <= 0
				 || startTime.toString().equals("null") || startTime.toString().equals("NULL")){
			 return "必填项缺失";
		 }
		 boolean type = startTime instanceof String;
		 if (type){
			 if(time1.check_len10(startTime.toString()).equals("0") 
					 || time1.check_len10(startTime.toString()).equals("1")){
				 return "不能晚于当前日期";
			 }
			 else if(time1.check_len10(startTime.toString()).equals("-1")){
				 return "right";
			 }
			 else{
				 return time1.check_len10(startTime.toString());
			 }
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkEndTime(Object endTime){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[8] = true;
		 TimeDatecheck time1 = new TimeDatecheck();
		 if (endTime == null || (endTime.toString()).length() <= 0
				 || endTime.toString().equals("null") || endTime.toString().equals("NULL")){
			 return "必填项缺失";
		 }
		 boolean type = endTime instanceof String;
		 if (type){
			 return time1.check_Expire(endTime.toString());
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkOperation(Object operation){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[9] = true;
		 if (operation == null || (operation.toString()).length() <= 0
				 || operation.toString().equals("null") || operation.toString().equals("NULL")){
			 return "必填项缺失";
		 }
		 boolean type = operation instanceof Integer;
		 if (type){
			 if (Integer.parseInt(operation.toString()) == 1 || Integer.parseInt(operation.toString()) == 2 || Integer.parseInt(operation.toString()) == 3){
				 return "right";
			 }
			 else
				 return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
}
