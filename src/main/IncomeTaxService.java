package main;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.xml.ws.Endpoint;


@WebService
public class IncomeTaxService {
    private IncomeTaxCalculator calculator = new IncomeTaxCalculator();

    @WebMethod
    public double calculateIncomeTax(double income) {
        return calculator.calculateIncomeTax(income);
    }

    public static void main(String[] args) {
        String address = "http://localhost:8080/income-tax-service";

        // 发布 Web 服务
        Endpoint.publish(address, new IncomeTaxService());

        System.out.println("Web service published. Access it at " + address + "?wsdl");
    }
}


