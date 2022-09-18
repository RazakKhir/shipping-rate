package com.calculator.shippingrate.service;

import com.calculator.shippingrate.entity.ShippingRateDetailEntity;
import com.calculator.shippingrate.model.ShippingRateDetailModel;
import com.calculator.shippingrate.repository.ShippingRateRepository;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ShippingRateSOImpl implements ShippingRateSO {

    @Autowired
    ShippingRateRepository shippingRateRepository;

    @Value("${endpoint.jntUrl}")
    private String jntUrl;
    @Value("${endpoint.clUrl}")
    private String clUrl;

    @Override
    public ShippingRateDetailModel saveShippingInfo(ShippingRateDetailModel shippingRateDetailModel) {
        ShippingRateDetailModel returnShippingRateDetModel = new ShippingRateDetailModel();
        ShippingRateDetailEntity returnShippingRateDetEntity = new ShippingRateDetailEntity();
        log.info("Start submitShippingRateInfo ... {}", shippingRateDetailModel);
        try {
            log.info("save submitShippingRateInfo ... ");
            returnShippingRateDetEntity = shippingRateRepository.save(toEntity(shippingRateDetailModel));
            returnShippingRateDetModel = toModel(returnShippingRateDetEntity);
            jntWebScrapeProcess(returnShippingRateDetModel);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            returnShippingRateDetModel.setErrorCode("ERR001");
            returnShippingRateDetModel.setErrorMessage("Error in Saving data ... " + e.getMessage());
        }
        log.info("End submitShippingRateInfo ...");
        return returnShippingRateDetModel;
    }

    @Override
    public void jntWebScrapeProcess(ShippingRateDetailModel shippingRateDetailModel) {
        HtmlPage jntPage;
        WebClient webClient = new WebClient();

        try {
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setJavaScriptEnabled(false);
            jntPage = webClient.getPage(jntUrl);
            HtmlForm form = jntPage.getForms().get(0);
            form.getInputByName("shipping_rates_type").setValueAttribute("domestic");
            form.getInputByName("sender_postcode").setValueAttribute(shippingRateDetailModel.getSenderPostcode());
            form.getInputByName("receiver_postcode").setValueAttribute(shippingRateDetailModel.getReceiverPostcode());
            if (form.getSelectByName("destination_country").asText() != null) {
                HtmlSelect select = form.getSelectByName("destination_country");
                HtmlOption option = select.getOptionByValue("BWN");
                select.setSelectedAttribute(option, true);
            }
            if (form.getSelectByName("shipping_type").asText() != null) {
                HtmlSelect select = form.getSelectByName("shipping_type");
                HtmlOption option = select.getOptionByValue("EZ");
                select.setSelectedAttribute(option, true);
            }
            form.getInputByName("weight").setValueAttribute(shippingRateDetailModel.getWeight());
            form.getInputByName("length").setValueAttribute(shippingRateDetailModel.getLength());
            form.getInputByName("width").setValueAttribute(shippingRateDetailModel.getWidth());
            form.getInputByName("height").setValueAttribute(shippingRateDetailModel.getHeight());

            log.info("shipping_rates_type: {}", form.getInputByName("shipping_rates_type").getValueAttribute());
            log.info("sender_postcode: {}", form.getInputByName("sender_postcode").getValueAttribute());
            log.info("receiver_postcode: {}", form.getInputByName("receiver_postcode").getValueAttribute());
            log.info("destination_country: {}", form.getSelectByName("destination_country").getSelectedOptions());
            log.info("shipping_type: {}", form.getSelectByName("shipping_type").getSelectedOptions());
            log.info("weight: {}", form.getInputByName("weight").getValueAttribute());
            log.info("length: {}", form.getInputByName("length").getValueAttribute());
            log.info("width: {}", form.getInputByName("width").getValueAttribute());
            log.info("height: {}", form.getInputByName("height").getValueAttribute());


            HtmlButton submitBtn = jntPage.getHtmlElementById("btn-form-rates-submit");
            submitBtn.click();
            webClient.waitForBackgroundJavaScript(80000);
            HtmlPage newPage = (HtmlPage) webClient.getCurrentWindow().getEnclosedPage();

            int hehe = newPage.getElementById("content").getChildElementCount();
            log.info("child element count: {}", hehe);

            // table table-bordered mb-0
//            HtmlDivision firstDiv = newPage.getHtmlElementById("content");
//            HtmlDivision secondDiv = (HtmlDivision) firstDiv.getByXPath("//div[@class='table-responsive shadow d-none d-sm-block']").get(0);
            HtmlTable resultTable = (HtmlTable) newPage.getByXPath("//table").get(0); // will get error here due to the div element is originally empty
            HtmlTableHeader resultTableHeader = resultTable.getHeader();
            final List<HtmlTableRow> headerRows = resultTableHeader.getRows();
            for (HtmlTableRow headerRow : headerRows) {
                log.info("header for row: {}", headerRow.getIndex());
                for (final HtmlTableCell cell : headerRow.getCells()) {
                    log.info("Found cell {}: ", cell.getIndex());
                    log.info("value: {}", cell.asText());
                }
            }

            for (HtmlTableBody resultTableBody : resultTable.getBodies()) {
                List<HtmlTableRow> resultTableBodyRows = resultTableBody.getRows();
                for (HtmlTableRow resultTableBodyRow : resultTableBodyRows) {
                    log.info("body for row: {}", resultTableBodyRow.getIndex());
                    for (final HtmlTableCell cell : resultTableBodyRow.getCells()) {
                        log.info("Found cell {}: ", cell.getIndex());
                        log.info("value: {}", cell.asText());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    private ShippingRateDetailEntity toEntity(ShippingRateDetailModel shippingRateDetailModel) {
        ShippingRateDetailEntity shippingRateDetailEntity = new ShippingRateDetailEntity();
        try {
            shippingRateDetailEntity.setLogisticComp(shippingRateDetailModel.getLogisticComp());
            shippingRateDetailEntity.setDestinationCountry(shippingRateDetailModel.getDestinationCountry());
            shippingRateDetailEntity.setSenderPostcode(shippingRateDetailModel.getSenderPostcode());
            shippingRateDetailEntity.setReceiverPostcode(shippingRateDetailModel.getReceiverPostcode());
            shippingRateDetailEntity.setWidth(shippingRateDetailModel.getWidth());
            shippingRateDetailEntity.setHeight(shippingRateDetailModel.getHeight());
            shippingRateDetailEntity.setLength(shippingRateDetailModel.getLength());
            shippingRateDetailEntity.setWeight(shippingRateDetailModel.getWeight());
            shippingRateDetailEntity.setTotalRate(shippingRateDetailModel.getTotalRate());
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return shippingRateDetailEntity;
    }

    private ShippingRateDetailModel toModel(ShippingRateDetailEntity shippingRateDetailEntity) {
        ShippingRateDetailModel shippingRateDetailModel = new ShippingRateDetailModel();
        try {
            shippingRateDetailModel.setId(shippingRateDetailEntity.getId());
            shippingRateDetailModel.setDestinationCountry(shippingRateDetailEntity.getDestinationCountry());
            shippingRateDetailModel.setSenderPostcode(shippingRateDetailEntity.getSenderPostcode());
            shippingRateDetailModel.setReceiverPostcode(shippingRateDetailEntity.getReceiverPostcode());
            shippingRateDetailModel.setLogisticComp(shippingRateDetailEntity.getLogisticComp());
            shippingRateDetailModel.setWidth(shippingRateDetailEntity.getWidth());
            shippingRateDetailModel.setHeight(shippingRateDetailEntity.getHeight());
            shippingRateDetailModel.setLength(shippingRateDetailEntity.getLength());
            shippingRateDetailModel.setWeight(shippingRateDetailEntity.getWeight());
            shippingRateDetailModel.setTotalRate(shippingRateDetailEntity.getTotalRate());
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return shippingRateDetailModel;
    }
}
