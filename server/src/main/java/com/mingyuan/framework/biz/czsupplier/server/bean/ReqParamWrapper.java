package com.mingyuan.framework.biz.czsupplier.server.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

public class ReqParamWrapper extends HttpServletRequestWrapper {

    public ReqParamWrapper(HttpServletRequest request) {
        super(request);
    }


    /**
     * 重写getInputStream方法
     * 取出requestBody的data部分
     */
    @Override
    public ServletInputStream getInputStream() throws IOException {
        if (!super.getHeader(HttpHeaders.CONTENT_TYPE).equalsIgnoreCase(MediaType.APPLICATION_JSON_VALUE)) {
            return super.getInputStream();
        }
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(super.getInputStream(), "UTF-8"));
        String line;
        String result = "";
        while ((line = reader.readLine()) != null) {
            result += line;
        }
        if (StringUtils.isEmpty(result)) {
            return super.getInputStream();
        }
        JSONObject jsonObject = JSON.parseObject(result);
        Object data = jsonObject.get("data");
        String dataStr = JSON.toJSONString(data);
        //重新构造输入流对象
        byte[] bytes = dataStr.getBytes("UTF-8");
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        return new MyServletInputStream(bis);
    }


    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

}

class MyServletInputStream extends ServletInputStream {

    private ByteArrayInputStream bis;

    public MyServletInputStream(ByteArrayInputStream bis) {
        this.bis = bis;
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public void setReadListener(ReadListener listener) {

    }

    @Override
    public int read() throws IOException {
        return bis.read();
    }
}



