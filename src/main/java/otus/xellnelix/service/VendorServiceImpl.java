package otus.xellnelix.service;

import org.springframework.stereotype.Service;
import otus.xellnelix.entity.Vendor;
import otus.xellnelix.repository.VendorRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendorServiceImpl implements VendorService{
    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public Vendor saveVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    @Override
    public List<Vendor> findAll() {
        List<Vendor> vendorList = new ArrayList<>();
        vendorRepository.findAll().forEach(vendorList::add);
        return vendorList;
    }
}
