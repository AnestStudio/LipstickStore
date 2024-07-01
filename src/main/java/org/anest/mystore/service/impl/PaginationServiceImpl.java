package org.anest.mystore.service.impl;

import org.anest.mystore.service.PaginationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.anest.mystore.constant.IConstants.LIMIT_PAGE;

@Service
public class PaginationServiceImpl implements PaginationService {

    @Override
    public List<Integer> getSimpleDisplayPages(int totalPages) {
        List<Integer> displayPages = new ArrayList<>();
        for (int i = 0; i < totalPages; i++) {
            displayPages.add(i);
        }
        return displayPages;
    }

    @Override
    public List<Integer> getDisplayPages(int currentPage, int totalPages) {
        List<Integer> displayPages = new ArrayList<>();

        if (currentPage <= 3) {
            for (int i = 0; i < 5; i++) {
                displayPages.add(i);
            }
            displayPages.add(LIMIT_PAGE);
            displayPages.add(totalPages - 1);
        } else if (currentPage >= totalPages - 4) {
            displayPages.add(0);
            displayPages.add(LIMIT_PAGE);
            for (int i = totalPages - 5; i < totalPages; i++) {
                displayPages.add(i);
            }
        } else {
            displayPages.add(0);
            displayPages.add(LIMIT_PAGE);
            for (int i = currentPage - 1; i <= currentPage + 1; i++) {
                displayPages.add(i);
            }
            displayPages.add(LIMIT_PAGE);
            displayPages.add(totalPages - 1);
        }
        return displayPages;
    }
}
