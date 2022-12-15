package pe.isil.ExamenFinalDESAI.affiliate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.ExamenFinalDESAI.visit.VisitDTO;

import java.util.List;
import java.util.Optional;

@Service
public class AffiliateServiceImpl implements AffiliateService {
    @Autowired
    private AffiliateRepository affiliateRepository;

    @Override
    public AffiliateDTO addAffiliate(Affiliate affiliate) {
        Optional<Affiliate> affiliateToAdd = affiliateRepository.findAffiliateByDniAffiliate(affiliate.getDniAffiliate());
        if (affiliateToAdd.isPresent()) {
            return AffiliateDTO.whenAffiliateDniAffiliateAlreadeyExists();
        } else {
            affiliateRepository.save(affiliate);
            return AffiliateDTO.whenAffiliateRegistrationSucced();
        }
    }

    @Override
    public Affiliate findAffiliateByDniAffiliate(String dni_affiliate) {
        Optional<Affiliate> affiliateToFind = affiliateRepository.findAffiliateByDniAffiliate(dni_affiliate);
        return affiliateToFind.orElse(null);
    }

    @Override
    public List<Affiliate> findAll() {
        return affiliateRepository.findAll();
    }

    @Override
    public AffiliateDTO updateAffiliate(Affiliate affiliate, Long id) {
        try {
            Optional<Affiliate> affiliateToUpdate = affiliateRepository.findById(id);
            if (affiliateToUpdate.isPresent()) {
                affiliateToUpdate.get().setName(affiliate.getDniAffiliate() != null ? affiliate.getDniAffiliate() : affiliateToUpdate.get().getDniAffiliate());
                affiliateToUpdate.get().setName(affiliate.getName() != null ? affiliate.getName() : affiliateToUpdate.get().getName());
                affiliateToUpdate.get().setLastname(affiliate.getLastname() != null ? affiliate.getLastname() : affiliateToUpdate.get().getLastname());
                affiliateToUpdate.get().setUrlPhoto(affiliate.getUrlPhoto() != null ? affiliate.getUrlPhoto() : affiliateToUpdate.get().getUrlPhoto());
                affiliateRepository.save(affiliateToUpdate.get());
                return AffiliateDTO.whenAffiliateRegistrationSucced();
            } else {
                return AffiliateDTO.whenError("Afiliado a actualizar no esta en la base de datos.");
            }
        } catch (Exception e) {
            return AffiliateDTO.whenError(e.getMessage());
        }

    }

    @Override
    public void deleteAffiliate(Long id) {
        Optional<Affiliate> affiliateToDelete = affiliateRepository.findById(id);
        affiliateToDelete.ifPresent(affiliate -> affiliateRepository.delete(affiliate));
    }

    @Override
    public Affiliate findAffiliateById(Long id) {
        return affiliateRepository.findById(id).orElse(null);
    }
}
