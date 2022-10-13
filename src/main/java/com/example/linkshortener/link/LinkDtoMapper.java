package com.example.linkshortener.link;

import com.example.linkshortener.link.dto.LinkDto;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

class LinkDtoMapper {
    public static LinkDto map(Link link) {
        String redirectUrl = buildRedirectUrlFromId(link.getId());
        return new LinkDto(link.getId(), link.getName(), link.getTargetUrl(), redirectUrl, link.getVisits());
    }

    private static String buildRedirectUrlFromId(String id) {
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/redir/{id}")
                .buildAndExpand(id)
                .toUriString();
    }
}