package exercise.purchase.service.impl;

import exercise.aspects.RequestLog;
import exercise.aspects.Time;
import exercise.common.exceptions.CustomException;
import exercise.common.services.BaseService;
import exercise.purchase.dto.PurchaseDto;
import exercise.purchase.model.PurchaseEntity;
import exercise.purchase.repository.PurchaseRepository;
import exercise.purchase.service.PurchaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@Service
public class PurchaseServiceImpl extends BaseService<PurchaseRepository,PurchaseEntity> implements PurchaseService {

    @Time
    @RequestLog
    public PurchaseDto getPurchaseByPurchaseId(String purchasId){
        try {
             return findById(purchasId, PurchaseDto.class);
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
    }


    /**
     * Metodo para crear un purchase.
     * @param dto, PurchaseDto
     * @return
     */
    @Time
    @RequestLog
    @Transactional
    public PurchaseDto createPurchase(PurchaseDto dto){

        log.info("Method saveOneProduct iniciando.");

        if (Optional.ofNullable(dto).map(PurchaseDto::getPurchaseId).map(t -> t == null).orElse(true)) {
            throw new RuntimeException("Favor de enviar un pago valido.");
        }

        try {
            return create(dto,PurchaseDto.class);

        }catch(Exception e){
            throw new CustomException("Ocurrio un error al generar el purchase.");
        }


    }

}
