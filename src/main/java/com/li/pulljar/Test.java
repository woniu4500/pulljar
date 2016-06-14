package com.li.pulljar;

public class Test {
	public static void main(String[]args){
        String parm = "420004198707030616"+"&"+"李欢";
        System.out.println("{\"auth_code\":\"M_APPPC_CERT\",\"state\":\"+parm+\"}");
        System.out.println("{'auth_code':'M_APPPC_CERT','state:'+parm}");
        StringBuffer sb = new StringBuffer();
        sb.append("{\"auth_code\":\"M_APPPC_CERT\",\"state\":\"");
        sb.append(parm);
        sb.append("\"}");
        System.out.println(sb.toString());
        
        
//		open_id=268814542987084613587891333&error_message=操作成功&state=420004198707030616|李欢&error_code=SUCCESS&app_id=1000383&success=true
        String decryptedStr = "open_id=268814542987084613587891333&error_message=操作成功&state=420004198707030616|李欢&error_code=SUCCESS&app_id=1000383&success=true";
        String [] strArray = decryptedStr.split("&");
        String open_id = "";
        String card_no = "";
        String name = "";
        for(String str :strArray){
        	if(str.contains("open_id")){
        		String [] array = str.split("=");
        		open_id = array[1];
        	}
        	if(str.contains("state")){
        		String [] array = str.split("=");
        		String st = array[1];
        		String [] starray = st.split("\\|");
        		card_no = starray[0];
        		name = starray[1];
        	}
        }
        System.out.println(open_id);
        System.out.println(card_no);
        System.out.println(name);
		}
}
