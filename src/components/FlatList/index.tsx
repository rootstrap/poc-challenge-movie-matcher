import React from 'react';
import { FlatListProps, ListRenderItem, FlatList as RNFlatList } from 'react-native';

import { Movie } from 'types/index';

import styles from './styles';

export type TItem = Movie & string;
export type { ListRenderItem };

type PropTypes = FlatListProps<TItem>;

const FlatList = ({
  data,
  keyExtractor,
  renderItem,
  style,
  contentContainerStyle,
  showsHorizontalScrollIndicator,
  showsVerticalScrollIndicator,
  ListHeaderComponent,
  ListHeaderComponentStyle,
  ListEmptyComponent,
  ...props
}: PropTypes) => (
  <RNFlatList
    {...props}
    data={data}
    keyExtractor={keyExtractor}
    renderItem={renderItem}
    style={style}
    contentContainerStyle={[styles.contentContainer, contentContainerStyle]}
    showsHorizontalScrollIndicator={showsHorizontalScrollIndicator}
    showsVerticalScrollIndicator={showsVerticalScrollIndicator}
    ListHeaderComponent={ListHeaderComponent}
    ListHeaderComponentStyle={ListHeaderComponentStyle}
    ListEmptyComponent={ListEmptyComponent}
  />
);

export default FlatList;
