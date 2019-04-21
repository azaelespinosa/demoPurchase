package exercise.purchase.model;

import exercise.common.entities.BaseEntity;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Table(name = "PURCHASE")
@Where(clause = "SOFT_DELETE=0")
public class PurchaseEntity extends BaseEntity {

    @Id
    @Column(name = "PURCHASE_ID", nullable = false, unique = true)
    private String purchaseId;

    @Column(name = "USER_ID", nullable = false)
    private String userId;

    @Column(name = "ORDER_ID")
    private Long orderId;

    @Column(name = "TRANS_NUM", nullable = false)
    private String transNum;

    @Column(name = "SUB_TOTAL", nullable = false)
    private BigDecimal subTotal;

    @Column(name = "IVA", nullable = false)
    private BigDecimal iva;

    @Column(name = "TOTAL", nullable = false)
    private BigDecimal total;

    @Column(name = "STATUS", nullable = false)
    private int status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TRANS_DATE", nullable = false)
    private Date transDate;

    @Column(name = "CLIENTE_ID", nullable = false)
    private Long clienteId;

    @Column(name = "payment_form", nullable = false)
    private String paymentForm;

    @Column(name = "payment_type", nullable = false)
    private String paymentType;

    @OrderBy("purchaseItemId ASC")
    @OneToMany
    @JoinColumn(name = "PURCHASE_ID", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<PurchaseDetailEntity> detailItems;


}