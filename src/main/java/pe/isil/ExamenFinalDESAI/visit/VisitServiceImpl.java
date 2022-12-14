package pe.isil.ExamenFinalDESAI.visit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.ExamenFinalDESAI.affiliate.Affiliate;
import pe.isil.ExamenFinalDESAI.affiliate.AffiliateRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VisitServiceImpl implements VisitService {
    @Autowired
    private VisitRepository visitRepository;
    @Autowired
    private AffiliateRepository affiliateRepository;

    @Override
    public VisitDTO addVisit(Visit visit) {
        Optional<Affiliate> visitToAdd = affiliateRepository.findAffiliateByDniAffiliate(visit.getDniAffiliate());
        if (visitToAdd.isPresent()) {
            visitRepository.save(visit);
            return VisitDTO.whenVisitRegistrationSucced();
        } else {
            return VisitDTO.whenVisitLocalAlreadeyNoExists();
        }
    }

    @Override
    public Visit findVisitByLocal(String local) {
        Optional<Visit> visitToFind = visitRepository.findVisitByLocal(local);
        return visitToFind.orElse(null);
    }

    @Override
    public List<Visit> findAll() {
        return visitRepository.findAll();
    }

    @Override
    public VisitDTO updateVisit(Visit visit, Long id) {
        try {
            Optional<Affiliate> visitToUpdateAffiliate = affiliateRepository.findAffiliateByDniAffiliate(visit.getDniAffiliate());
            if (visitToUpdateAffiliate.isPresent()) {
                Optional<Visit> visitToUpdate = visitRepository.findById(id);
                if (visitToUpdate.isPresent()) {
                    visitToUpdate.get().setLocal(visit.getLocal() != null ? visit.getLocal() : visitToUpdate.get().getLocal());
                    visitToUpdate.get().setDniAffiliate(visit.getDniAffiliate() != null ? visit.getDniAffiliate() : visitToUpdate.get().getDniAffiliate());
                    visitToUpdate.get().setDate(visit.getDate() != null ? visit.getDate() : visitToUpdate.get().getDate());
                    visitToUpdate.get().setHour(visit.getHour() != null ? visit.getHour() : visitToUpdate.get().getHour());
                    visitRepository.save(visitToUpdate.get());
                    return VisitDTO.whenVisitRegistrationSucced();
                } else {
                    return VisitDTO.whenError("Visita a actualizar no esta en la base de datos.");
                }
            } else {
                return VisitDTO.whenVisitLocalAlreadeyNoExists();
            }
        } catch (Exception e) {
            return VisitDTO.whenError(e.getMessage());
        }
    }

    @Override
    public void deleteVisit(Long id) {
        Optional<Visit> applicationToDelete = visitRepository.findById(id);
        applicationToDelete.ifPresent(application -> visitRepository.delete(application));
    }

    @Override
    public Visit findVisitById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }
}
