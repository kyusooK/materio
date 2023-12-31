package wizmokeycloak.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import wizmokeycloak.BasicApplication;
import wizmokeycloak.domain.CompanyDeleted;
import wizmokeycloak.domain.CompanyUpdated;

@Entity
@Table(name = "Company_table")
@Data
//<<< DDD / Aggregate Root
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String code;

    private String name;

    private String industry;

    private LocalDate foundedDate;

    private Long codeNum;

    @Embedded
    private Photo photo;

    @Embedded
    private Address address;

    @Embedded
    private Weather weather;

    @PostPersist
    public void onPostPersist() {
        CompanyUpdated companyUpdated = new CompanyUpdated(this);
        companyUpdated.publishAfterCommit();

        CompanyDeleted companyDeleted = new CompanyDeleted(this);
        companyDeleted.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {}

    public static CompanyRepository repository() {
        CompanyRepository companyRepository = BasicApplication.applicationContext.getBean(
            CompanyRepository.class
        );
        return companyRepository;
    }

    //<<< Clean Arch / Port Method
    public void createCompany(CreateCompanyCommand createCompanyCommand) {
        //implement business logic here:

        CompanyCreated companyCreated = new CompanyCreated(this);
        companyCreated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
