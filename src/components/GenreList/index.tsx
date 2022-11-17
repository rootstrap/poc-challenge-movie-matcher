import React from 'react';
import { Text, View } from 'react-native';

import FlatList, { ListRenderItem, TItem } from 'components/FlatList';
import ListItemSeparator from 'components/ListItemSeparator';

import { Movie } from 'types/index';

import styles from './styles';

type PropTypes = { genres: Movie['genres'] };

const MAX_GENRES = 2;

const GenreList: React.FunctionComponent<PropTypes> = ({ genres }) => {
  const renderItem: ListRenderItem<string> = ({ item }) => (
    <Text key={item} style={styles.genreText}>
      {item.toUpperCase()}
    </Text>
  );

  const keyExtractor = (genre: string, index: number) => genre || String(index);
  const data = genres.slice(0, MAX_GENRES);
  return (
    <FlatList
      data={data as TItem[]}
      style={styles.listContainer}
      contentContainerStyle={styles.listContent}
      keyExtractor={keyExtractor}
      renderItem={renderItem}
      horizontal
      keyboardShouldPersistTaps="handled"
      ItemSeparatorComponent={() => <ListItemSeparator style={styles.separator} />}
      ListFooterComponent={() =>
        genres?.length > MAX_GENRES ? (
          <View style={styles.moreGenresContainer}>
            <Text>+{genres.length - MAX_GENRES}</Text>
          </View>
        ) : null
      }
      showsHorizontalScrollIndicator={false}
    />
  );
};

export default GenreList;
