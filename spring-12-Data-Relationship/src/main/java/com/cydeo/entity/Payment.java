package com.cydeo.entity;

import com.cydeo.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DATE")
    private LocalDate createdDate;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private Status paymentStatus;
    //cascade->both action do same time,when you do something in the table,same thing is happened in the child as well
//   @OneToOne(cascade = CascadeType.ALL) //when you try to do any action in the payment object
//   , same action is happened payment detail as well,but generally we don't use type all
  @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
//   @JoinColumn(name ="payment_detail_id" )//change column foreign key name
   private PaymentDetail paymentDetail;
  @ManyToOne //many payment to one merchant
  private Merchant merchant;

    public Payment(LocalDate createdDate, BigDecimal amount, Status paymentStatus) {
        this.createdDate = createdDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

}
