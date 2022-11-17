import { StyleSheet } from 'react-native';

import { BLACK } from 'constants/colors';

export default StyleSheet.create({
  listContainer: {
    maxHeight: 30,
    marginTop: 7,
  },
  listContent: {
    padding: 0,
  },
  genreText: {
    maxHeight: 30,
    borderRadius: 4,
    borderWidth: 1,
    borderColor: BLACK,
    color: BLACK,
    padding: 4,
  },
  moreGenresContainer: {
    height: 30,
    justifyContent: 'center',
    alignItems: 'center',
    marginLeft: 5,
  },
  separator: {
    marginVertical: 0,
    marginHorizontal: 3,
  },
});
