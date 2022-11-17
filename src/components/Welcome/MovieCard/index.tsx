import React from 'react';
import { Text } from 'react-native';

import Card from 'components/Card';
import Image from 'components/Image';
import View from 'components/View';

import { Movie } from 'types/index';

import styles from './styles';

type PropTypes = {
  movie: Movie;
};

const MovieCard: React.FunctionComponent<PropTypes> = ({ movie }) => {
  return (
    <Card onPress={() => console.warn('holis!')}>
      <View style={styles.body}>
        <View style={styles.left}>
          <Image
            style={styles.image}
            source={{
              uri: 'https://cdns.cloudflare.steamstatic.com/steamcommunity/public/images/avatars/f4/f4a392996bb43609d2512a48e81b7ef8d3238827_full.jpg',
            }}
            resizeMode="cover"
          />
        </View>
        <View style={styles.right}>
          <Text>Right content</Text>
        </View>
      </View>
      <View style={styles.footer}>
        <Text>Footer :)</Text>
      </View>
    </Card>
  );
};

export default MovieCard;
