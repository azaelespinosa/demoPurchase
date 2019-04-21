package exercise.purchase.controllers;

import exercise.purchase.dto.PurchaseDto;
import exercise.purchase.service.PurchaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/purchase")
@Api(description = "Purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;


    @GetMapping(value = "/find/{purchaseId}")
    @ApiOperation(value = "Busca un purchase por purchase id.")
    public PurchaseDto getCustomerById(@PathVariable String purchaseId) {
        return purchaseService.getPurchaseByPurchaseId(purchaseId);
    }

    @PostMapping(value = "/create")
    @ApiOperation(value = "Genera el pago de productos.")
    public PurchaseDto createPurchase(@RequestBody PurchaseDto dto){
        return purchaseService.createPurchase(dto);
    }

}
