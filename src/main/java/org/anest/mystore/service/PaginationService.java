package org.anest.mystore.service;

import java.util.List;

public interface PaginationService {

    List<Integer> getSimpleDisplayPages(int totalPages);

    List<Integer> getDisplayPages(int currentPage, int totalPages);
}
