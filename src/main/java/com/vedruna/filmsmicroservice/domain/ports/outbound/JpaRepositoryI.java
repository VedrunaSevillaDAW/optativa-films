package com.vedruna.filmsmicroservice.domain.ports.outbound;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vedruna.filmsmicroservice.domain.model.FilmModel;

public interface JpaRepositoryI {

    /**
     * Busca una película por su título exacto.
     * Genera una consulta SQL con la cláusula {@code f.title = 'title'}.
     * 
     * @param title El título de la película a buscar.
     * @return El objeto {@code Optional} que contiene la {@code FilmModel} si se
     *         encuentra,
     *         o un {@code Optional} null si no hay coincidencias.
     */
    Optional<FilmModel> findByTitle(String title);

    /**
     * Busca una película por su título ignorando mayúsculas y minúsculas.
     * Genera una consulta SQL con la cláusula
     * {@code LOWER(f.title) = LOWER('title')}.
     * 
     * @param title El título de la película a buscar.
     * @return El objeto {@code Optional} que contiene la {@code FilmModel} si se
     *         encuentra,
     *         o un {@code Optional} null si no hay coincidencias.
     */
    Optional<FilmModel> findByTitleIgnoreCase(String title);

    /**
     * Busca películas cuyo título comienza con el valor proporcionado, aplicando
     * paginación.
     * Genera una consulta SQL con la cláusula {@code LIKE 'title%'}.
     *
     * @param title    El prefijo del título a buscar.
     * @param pageable La información de paginación y ordenamiento (la página, el
     *                 tamaño de página y el orden).
     * @return El objeto {@code Page} contiene la lista de resultados de
     *         {@code FilmModel} y metadatos de paginación.
     */
    Page<FilmModel> findByTitleStartingWith(String title, Pageable pageable);

    /**
     * Busca películas cuyo título termine con el valor proporcionado, aplicando
     * paginación.
     * Genera una consulta SQL con la cláusula {@code LIKE '%title'}.
     *
     * @param title    El sufijo del título a buscar.
     * @param pageable La información de paginación y ordenamiento (la página, el
     *                 tamaño de página y el orden).
     * @return El objeto {@code Page} contiene la lista de resultados de
     *         {@code FilmModel} y metadatos de paginación.
     */
    Page<FilmModel> findByTitleEndingWith(String title, Pageable pageable);

    /**
     * Busca películas cuyo título contenga el valor proporcionado, aplicando
     * paginación.
     * Genera una consulta SQL con la cláusula {@code LIKE '%title%'}.
     *
     * @param title    El valor contenido del título a buscar.
     * @param pageable La información de paginación y ordenamiento (la página, el
     *                 tamaño de página y el orden).
     * @return El objeto {@code Page} contiene la lista de resultados de
     *         {@code FilmModel} y metadatos de paginación.
     */
    Page<FilmModel> findByTitleContaining(String title, Pageable pageable);
    // Hace lo mismo -> Page<FilmModel> findByTitleContains(String title, Pageable
    // pageable);

    /**
     * Busca películas cuyo título coincida con un patrón SQL 'LIKE', aplicando
     * paginación.
     * Genera una consulta SQL con la cláusula {@code LIKE 'title'}.
     *
     * @param title    El patrón 'LIKE' del título a buscar.
     * @param pageable La información de paginación y ordenamiento (la página, el
     *                 tamaño de página y el orden).
     * @return El objeto {@code Page} contiene la lista de resultados de
     *         {@code FilmModel} y metadatos de paginación.
     */
    Page<FilmModel> findByTitleLike(String title, Pageable pageable);

    /**
     * Busca películas cuyo título se encuentre en la lista proporcionada, aplicando
     * paginación.
     * Genera una consulta SQL con la cláusula {@code IN titles}.
     *
     * @param titles   La lista de títulos a buscar.
     * @param pageable La información de paginación y ordenamiento (la página, el
     *                 tamaño de página y el orden).
     * @return El objeto {@code Page} contiene la lista de resultados de
     *         {@code FilmModel} y metadatos de paginación.
     */
    Page<FilmModel> findByTitleIn(List<String> titles, Pageable pageable);

    /**
     * Busca películas que coincidan exactamente con el título Y la fecha de
     * lanzamiento proporcionados,
     * aplicando paginación.
     * Genera una consulta SQL con la cláusula
     * {@code f.title = 'title' AND f.release_date = 'releaseDate'}.
     *
     * @param title       El título de la película.
     * @param releaseDate La fecha de lanzamiento.
     * @param pageable    La información de paginación y ordenamiento (la página, el
     *                    tamaño de página y el orden).
     * @return El objeto {@code Page} contiene la lista de resultados de
     *         {@code FilmModel} y metadatos de paginación.
     */
    Page<FilmModel> findByTitleAndReleaseDate(String title, LocalDate releaseDate, Pageable pageable);

    /**
     * Busca películas que coincidan exactamente con el título O la fecha de
     * lanzamiento proporcionados,
     * aplicando paginación.
     * Genera una consulta SQL con la cláusula
     * {@code f.title = 'title' OR f.release_date = 'releaseDate'}.
     *
     * @param title       El título de la película.
     * @param releaseDate La fecha de lanzamiento.
     * @param pageable    La información de paginación y ordenamiento (la página, el
     *                    tamaño de página y el orden).
     * @return El objeto {@code Page} contiene la lista de resultados de
     *         {@code FilmModel} y metadatos de paginación.
     */
    Page<FilmModel> findByTitleOrReleaseDate(String title, LocalDate releaseDate, Pageable pageable);

    /**
     * Busca películas cuya fecha de lanzamiento esté entre las dos fechas
     * proporcionadas,
     * aplicando paginación.
     * Genera una consulta SQL con la cláusula
     * {@code f.release_date BETWEEN 'from' AND 'to'}.
     *
     * @param from     La fecha de inicio del rango (inclusivo).
     * @param to       La fecha de fin del rango (inclusivo).
     * @param pageable La información de paginación y ordenamiento (la página, el
     *                 tamaño de página y el orden).
     * @return El objeto {@code Page} contiene la lista de resultados de
     *         {@code FilmModel} y metadatos de paginación.
     */
    Page<FilmModel> findByReleaseDateBetween(LocalDate from, LocalDate to, Pageable pageable);

    /**
     * Busca películas cuya fecha de lanzamiento sea anterior a la fecha
     * proporcionada,
     * aplicando paginación.
     * Genera una consulta SQL con la cláusula {@code f.release_date < 'to'}.
     *
     * @param to       La fecha límite (exclusiva).
     * @param pageable La información de paginación y ordenamiento (la página, el
     *                 tamaño de página y el orden).
     * @return El objeto {@code Page} contiene la lista de resultados de
     *         {@code FilmModel} y metadatos de paginación.
     */
    Page<FilmModel> findByReleaseDateBefore(LocalDate to, Pageable pageable);

    /**
     * Busca películas cuya fecha de lanzamiento sea posterior a la fecha
     * proporcionada,
     * aplicando paginación.
     * Genera una consulta SQL con la cláusula {@code f.release_date > 'from'}.
     *
     * @param from     La fecha de inicio (exclusiva).
     * @param pageable La información de paginación y ordenamiento (la página, el
     *                 tamaño de página y el orden).
     * @return El objeto {@code Page} contiene la lista de resultados de
     *         {@code FilmModel} y metadatos de paginación.
     */
    Page<FilmModel> findByReleaseDateAfter(LocalDate from, Pageable pageable);

    /**
     * Busca todos los posters distintos con una query personalizada (el nombre del
     * método puede ser cualquiera),
     * aplicando paginación.
     * Genera una consulta SQL personalizada
     * {@code SELECT DISTINCT f.poster FROM FilmModel f [Paginación]}.
     *
     * @param pageable La información de paginación y ordenamiento (la página, el
     *                 tamaño de página y el orden).
     * @return El objeto {@code Page} contiene la lista de resultados de
     *         {@code FilmModel} y metadatos de paginación.
     */
    @Query("SELECT DISTINCT f.poster FROM FilmModel f")
    Page<String> obtainPosterPaths(Pageable pageable);

    /**
     * Busca películas que no tengan póster (póster nulo),
     * aplicando paginación.
     * Genera una consulta SQL con la clausula {@code f.poster IS NULL}.
     *
     * @param pageable La información de paginación y ordenamiento (la página, el
     *                 tamaño de página y el orden).
     * @return El objeto {@code Page} contiene la lista de resultados de
     *         {@code FilmModel} y metadatos de paginación.
     */
    Page<FilmModel> findByPosterIsNull(Pageable pageable);

    /**
     * Busca películas que tengan póster (póster no nulo),
     * aplicando paginación.
     * Genera una consulta SQL con la clausula {@code f.poster IS NOT NULL}.
     *
     * @param pageable La información de paginación y ordenamiento (la página, el
     *                 tamaño de página y el orden).
     * @return El objeto {@code Page} contiene la lista de resultados de
     *         {@code FilmModel} y metadatos de paginación.
     */
    Page<FilmModel> findByPosterNotNull(Pageable pageable);

    /**
     * Busca películas que estén en cines (inCinemas = true),
     * aplicando paginación.
     * Genera una consulta SQL con la clausula {@code f.in_cinemas = true}.
     *
     * @param pageable La información de paginación y ordenamiento (la página, el
     *                 tamaño de página y el orden).
     * @return El objeto {@code Page} contiene la lista de resultados de
     *         {@code FilmModel} y metadatos de paginación.
     */
    Page<FilmModel> findByInCinemasTrue(Pageable pageable);

    /**
     * Busca películas que no estén en cines (inCinemas = false),
     * aplicando paginación.
     * Genera una consulta SQL con la clausula {@code f.in_cinemas = false}.
     *
     * @param pageable La información de paginación y ordenamiento (la página, el
     *                 tamaño de página y el orden).
     * @return El objeto {@code Page} contiene la lista de resultados de
     *         {@code FilmModel} y metadatos de paginación.
     */
    Page<FilmModel> findByInCinemasFalse(Pageable pageable);

    /**
     * Busca películas que distintas con el rating proporcionado,
     * aplicando paginación.
     * Genera una consulta SQL con la clausula {@code f.rating = 'rating'}.
     *
     * @param rating   El rating de las películas.
     * @param pageable La información de paginación y ordenamiento (la página, el
     *                 tamaño de página y el orden).
     * @return El objeto {@code Page} contiene la lista de resultados de
     *         {@code FilmModel} y metadatos de paginación.
     */
    Page<FilmModel> findDistinctByRating(Float rating, Pageable pageable);

    /**
     * Busca películas cuyo rating sea menor al proporcionado,
     * aplicando paginación.
     * Genera una consulta SQL con la clausula {@code f.rating < 'rating'}.
     *
     * @param rating   El valor máximo de calificación (exclusivo).
     * @param pageable La información de paginación y ordenamiento (la página, el
     *                 tamaño de página y el orden).
     * @return El objeto {@code Page} contiene la lista de resultados de
     *         {@code FilmModel} y metadatos de paginación.
     */
    Page<FilmModel> findByRatingLessThan(Float rating, Pageable pageable);

    /**
     * Busca películas cuyo rating sea mayor o igual al proporcionado,
     * aplicando paginación.
     * Genera una consulta SQL con la clausula {@code f.rating < 'rating'}.
     *
     * @param rating   El valor mínimo de calificación (exclusivo).
     * @param pageable La información de paginación y ordenamiento (la página, el
     *                 tamaño de página y el orden).
     * @return El objeto {@code Page} contiene la lista de resultados de
     *         {@code FilmModel} y metadatos de paginación.
     */
    Page<FilmModel> findByRatingGreaterThanEqual(Float rating, Pageable pageable);

    /**
     * Busca todas las películas que han sido vistas por un usuario específico
     * (identificado por su ID),
     * aplicando paginación.
     * Genera una consulta JPQL personalizada para realizar una unión (JOIN) entre
     * {@code FilmModel}
     * y {@code UserEntity} a través de la relación Many-to-Many.
     *
     * @param id       El ID del usuario cuyas películas vistas se quieren obtener
     *                 (parámetro en la JPQL).
     * @param pageable La información de paginación y ordenamiento (la página, el
     *                 tamaño de página y el orden).
     * @return El objeto {@code Page} contiene la lista de resultados de
     *         {@code FilmModel} y metadatos de paginación.
     */
    @Query("SELECT f FROM FilmModel f JOIN f.usersWatchedThisFilm u WHERE u.userId = :id")
    Page<FilmModel> findFilmByUser(@Param("id") Integer id, Pageable pageable);
}
