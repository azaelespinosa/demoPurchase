package exercise.purchase.service;

import exercise.purchase.dto.PurchaseDto;

public interface PurchaseService {

    PurchaseDto getPurchaseByPurchaseId(String purchasId);

    PurchaseDto createPurchase(PurchaseDto dto);
}
