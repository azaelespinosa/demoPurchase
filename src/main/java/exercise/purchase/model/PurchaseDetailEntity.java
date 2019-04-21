package exercise.purchase.model;

import exercise.common.entities.BaseEntity;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Table(name = "PURCHASE_DETAIL")
@Where(clause = "SOFT_DELETE=0")
public class PurchaseDetailEntity extends BaseEntity {

    @Id
    @Column(name = "PURCHASE_ITEM_ID", unique = true, nullable = false)
    private String purchaseItemId;

    @Column(name = "PURCHASE_ID", nullable = false)
    private String purchaseId;

    @Column(name = "ITEM_ID", nullable = false)
    private Long itemId;

    @Column(name = "QTY", nullable = false)
    private int qty;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;



}
