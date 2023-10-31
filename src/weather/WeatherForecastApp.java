package weather;
import javax.xml.soap.*;
import java.io.*;

public class WeatherForecastApp {
    public static void main(String[] args) {
        try {
            // 创建SOAP连接
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // 创建SOAP消息
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage();

            // 创建SOAP部分
            SOAPPart soapPart = soapMessage.getSOAPPart();

            // 创建SOAP信封
            SOAPEnvelope envelope = soapPart.getEnvelope();
            envelope.addNamespaceDeclaration("web", "http://WebXml.com.cn/");

            // 创建SOAP体
            SOAPBody soapBody = envelope.getBody();
            SOAPElement soapElement = soapBody.addChildElement("getWeatherbyCityName", "web");
            SOAPElement soapCityName = soapElement.addChildElement("theCityName", "web");
            soapCityName.addTextNode("北京"); // 您可以根据需要更改城市名称

            // 设置SOAP消息属性
            soapMessage.saveChanges();

            // 发送SOAP请求并获取响应
            String url = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx";
            SOAPMessage soapResponse = soapConnection.call(soapMessage, url);

            // 解析SOAP响应
            SOAPBody responseBody = soapResponse.getSOAPBody();
            String weatherInfo = responseBody.getElementsByTagName("getWeatherbyCityNameResult").item(0).getTextContent();

            // 打印天气预报信息
            System.out.println("城市：北京");
            System.out.println("天气预报：" + weatherInfo);

            // 关闭SOAP连接
            soapConnection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
