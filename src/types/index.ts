export type RecommendedBy = {
  name: string;
  avatar: string;
};
export type Movie = {
  genres: string[];
  recommended_by: RecommendedBy[];
  id: number;
  original_language: string;
  original_title: string;
  overview: string;
  popularity: number;
  poster_path: string;
  release_date: string;
  title: string;
  video: boolean;
  vote_average: number;
  vote_count: number;
};
