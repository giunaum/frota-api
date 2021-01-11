package br.com.test.frota.service.dto.mapper;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.domain.Page;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public interface InterfaceMapper<T, D> {

	T toDocument(D dto);

	D toDTO(T document);

	default Page<D> toPageDTO(Page<T> document) {
		return Objects.nonNull(document) && !document.isEmpty() ? document.map(this::toDTO) : Page.empty();
	}

	default List<D> toListDTO(List<T> documents) {
		return CollectionUtils.isNotEmpty(documents)
				? documents.stream().filter(Objects::nonNull).map(this::toDTO).collect(Collectors.toList())
				: Collections.emptyList();
	}

	default List<T> toListDocument(List<D> dtos) {
		return CollectionUtils.isNotEmpty(dtos)
				? dtos.stream().filter(Objects::nonNull).map(this::toDocument).collect(Collectors.toList())
				: Collections.emptyList();
	}
}
